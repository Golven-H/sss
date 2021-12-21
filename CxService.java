package springbootTest.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

@Service
public class CxService {
	public String test(String ZipArea,Integer CCertId,String VehicleId,String VclIdColor) throws UnsupportedEncodingException {
		String getUrl = "http://www.gxdlys.com/PublicService/VehicleCert/QueryVehicleByFilter?"
				+ "ZipArea=ZIPARAE&CCertId=CCERTID&VehicleId=VEHICLEID&VclIdColor=VCLIDCOLOR";
		String replace = getUrl.replace("ZIPARAE", URLEncoder.encode(ZipArea, "UTF-8"))
				.replace("CCERTID",CCertId == null ?"":URLEncoder.encode(String.valueOf(CCertId),"UTF-8"))
				.replace("VEHICLEID", URLEncoder.encode(VehicleId, "UTF-8"))
				.replace("VCLIDCOLOR", URLEncoder.encode(VclIdColor, "UTF-8"));
		HttpURLConnection connection = null;
		InputStream is = null;
		BufferedReader br = null;
		String resule = null;
		try {
			URL url = new URL(replace);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(15000);
			connection.setReadTimeout(60000);
			connection.connect();
			if(connection.getResponseCode() == 200) {
				is = connection.getInputStream();
				br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
				StringBuffer sbf = new StringBuffer();
				String temp = null;
				while((temp = br.readLine()) != null) {
					sbf.append(temp);
					sbf.append("\r\n");
				}
				resule = sbf.toString();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(null != br) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(null != is) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			connection.disconnect();
		}
		System.out.println(replace);
		System.out.println("*************");
		return resule;
	}
}
