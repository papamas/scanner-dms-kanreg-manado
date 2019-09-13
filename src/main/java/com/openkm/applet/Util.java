/**
 *  OpenKM, Open Document Management System (http://www.openkm.com)
 *  Copyright (c) 2006-2010  Paco Avila & Josep Llort
 *
 *  No bytes were intentionally harmed during the development of this application.
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along
 *  with this program; if not, write to the Free Software Foundation, Inc.,
 *  51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package com.openkm.applet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import org.apache.commons.io.FileUtils;


import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class Util {
	private static Logger log = Logger.getLogger(Util.class.getName());
    
	/**
	 * Upload scanned document to OpenKM
	 * 
	 */
	public static void createDocument(String token,String folder, String path, String fileName, String fileType,
			String url, List<BufferedImage> images) throws MalformedURLException, IOException, ParseException {
		log.info("createDocument(" + token + ", " + folder + ", " + path + ", " + fileName + ", " + fileType +
				", " + url + ", " + images + ")");
		File tmpDir = createTempDir();
                
                File file = new File(tmpDir + "/" + folder);
                if (!file.exists()) {
                    if (file.mkdir()) {
                        System.out.println("Directory is created!");
                    } else {
                        System.out.println("Failed to create directory!");
                    }
                }
		File tmpFile = new File(tmpDir + "/" + folder, fileName + "." + fileType);
		ImageOutputStream ios = ImageIO.createImageOutputStream(tmpFile);
		String response = "";
                          
		try {
			if ("pdf".equals(fileType)) {
				ImageUtils.writePdf(images, ios);
			} else if ("tif".equals(fileType)) {
				ImageUtils.writeTiff(images, ios);
			} else {
				if (!ImageIO.write(images.get(0), fileType, ios)) {
					throw new IOException("Not appropiated writer found!");
				}
			}
			
			ios.flush();
			ios.close();
                        
                        // Store in disk
                        String home = System.getProperty("user.home");
                        File dst = new File(home, tmpFile.getName());
                        copyFile(tmpFile, dst);
                         
			
		} finally {
                    displayDirectoryContents(token, path,folder, url,tmpDir);
		    FileUtils.deleteQuietly(tmpDir);
		}
		
		log.info("createDocument: "+response);
		//return response;
	}
	
	/**
	 * Creates a temporal and unique directory
	 * 
	 * @throws IOException If something fails.
	 */
	public static File createTempDir() throws IOException {
		File tmpFile = File.createTempFile("okm", null);
		
		if (!tmpFile.delete())
            throw new IOException();
        if (!tmpFile.mkdir())
            throw new IOException();
        
        return tmpFile;       
	}
	
	/**
	 * 
	 */
	public static Locale parseLocaleString(String localeString) {
		if (localeString == null) {
			localeString = "en-GB";
		}
		 
		String[] parts = localeString.split("-");
		String language = (parts.length > 0 ? parts[0] : "");
		String country = (parts.length > 1 ? parts[1] : "");
		return (language.length() > 0 ? new Locale(language, country) : null);
	 }
	
	/**
	 * Copy file
	 */
	private static void copyFile(File fromFile, File toFile) throws IOException {
	    FileInputStream from = null;
	    FileOutputStream to = null;
	    
	    try {
	    	from = new FileInputStream(fromFile);
	    	to = new FileOutputStream(toFile);
	    	byte[] buffer = new byte[4096];
	    	int bytesRead;
	    	
	    	while ((bytesRead = from.read(buffer)) != -1) {
	            to.write(buffer, 0, bytesRead);
	    	}
	    } finally {
	    	if (from != null) {
	    		try {
	    			from.close();
	    		} catch (IOException e) {}
	    	}
	    	
	    	if (to != null) {
	    		try {
	    			to.close();
	    		} catch (IOException e) {}
	    	}
	    }
	}
        
        /**
	 * Call to create document
	 */
	public static String createDoc(String token, String path, String url, File file) throws IOException {
		log.info("createDoc(" + token + ", " + path + ", " + url + ", " + file.getAbsolutePath() + ")");
		CloseableHttpClient httpclient = HttpClients.createDefault();             
                // build multipart upload request
                HttpEntity data = MultipartEntityBuilder.create()
                        .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                        .addPart("file",new FileBody(file, ContentType.DEFAULT_BINARY))
                        .addPart("path", new StringBody(path, Charset.forName("UTF-8")))
                        .addPart("action",new StringBody("0"))
                        .build();
                // build http request and assign multipart upload data
                HttpUriRequest request = RequestBuilder
                        .post(url + "/frontend/FileUpload;jsessionid=" + token)
                        .setEntity(data)
                        .build();

                // Create a custom response handler
                ResponseHandler<String> responseHandler = respon -> {
                    int status = respon.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = respon.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                };
                String responseBody = httpclient.execute(request, responseHandler);
                String response = responseBody;
		log.info("createDocument: " + response);
		return response;
	}
        /**
	 * Call to create folder
	 */
	public static String createFolder(String token, String path, String url, File file) throws IOException {
		log.info("createFolder(" + token + ", " + path + ", " + url + ", " + file + ")");
                
                CloseableHttpClient httpclient = HttpClients.createDefault();
                // build multipart upload request
                HttpEntity data = MultipartEntityBuilder.create()
                       .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                       .addPart("folder", new StringBody(file.getName()))
                       .addPart("path", new StringBody(path, Charset.forName("UTF-8")))
                       .addPart("action",new StringBody("2"))
                       .build();
                // build http request and assign multipart upload data
                HttpUriRequest request = RequestBuilder
                       .post(url + "/frontend/FileUpload;jsessionid=" + token)
                       .setEntity(data)
                       .build();
                // Create a custom response handler
                ResponseHandler<String> responseHandler = respon -> {
                    int status = respon.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = respon.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                };
                String responseBody = httpclient.execute(request, responseHandler);
                System.out.println("----------------------------------------");
                System.out.println(responseBody); 
                String response = responseBody;                                
		log.info("createFolder: " + response);
		return response;
	}
        
    public static void displayDirectoryContents(String token, String path,String folder,String url,File dir) throws ParseException {
        try {
                File[] files = dir.listFiles();     
                String response;
                for (File file : files) {
                        if (file.isDirectory()) {
                            log.info("== create folder=="+ token + "," + path + "," + url + "," + file.getName());
                            
                            response = createFolder(token, path, url, file);
                            displayDirectoryContents(token, path,folder,url, file);
                        } else {
                            log.info("== create file=="+ token + "," + path+","+folder+ "," + url + "," + file.getName());
                            response = createDoc(token, path +"/"+folder,url, file);    
                            
                            log.info("=== Response displayDirectoryContents===" + response);
                                        
                            JSONParser parser = new JSONParser();
                            JSONObject jsonObject = (JSONObject) parser.parse(response);
                            String error = (String) jsonObject.get("error");

                            if (response.contains("OKM")) {
                                log.log(Level.SEVERE, "Error: " + response);
                                ErrorCode.displayError(error, file.getName());


                            }    
                        }
                        
                       
                }
        } catch (IOException e) {
                e.printStackTrace();
        }
    }    

    
}
