//package newsapp;
//
//import java.io.IOException;
//import java.net.URISyntaxException;
//
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.utils.URIBuilder;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//import org.junit.Test;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//
//public class HttpGetTest {
//	
//	//没有参数的get请求
//	@Test
//	public void httpGet() {
//		CloseableHttpClient httpClient = HttpClients.createDefault();
//		HttpGet httpGet = new HttpGet("http://c.m.163.com/nc/article/headline/T1348647853363/0-40.html");
//		CloseableHttpResponse response = null;
//		try {
//			response = httpClient.execute(httpGet);
//			// 响应码为200成功
//			if (response.getStatusLine().getStatusCode() == 200) {
//				String data = EntityUtils.toString(response.getEntity(), "utf-8");
//				
//				JSONObject array = JSON.parseObject(data.toString());
////				Object object = array.get("T1348647853363");
////				JSONObject object1 = JSON.parseObject(object.toString());
//				System.out.println(array.getString("T1348647853363"));
//			
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				response.close();
//				httpClient.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//		}
//	}
//	
//	//带参数的get请求
//	@Test
//	public void httpGetByParam() {
//		CloseableHttpClient httpClient = null;
//		URIBuilder uriBuilder = null;
//		HttpGet httpGet =null;
//		CloseableHttpResponse response = null;
//		try {
//			httpClient = HttpClients.createDefault();
//			//使用URIBuilder创建uri对象可设置参数
//			uriBuilder = new URIBuilder("http://3g.163.com/touch/jsonp/joke/chanListNews/T1419316284722/2/0-10.html?");
//			//setParameter链式调用设置多组参数
//			uriBuilder.setParameter("callback", "joke0");
//			httpGet = new HttpGet(uriBuilder.build());
//			response = httpClient.execute(httpGet);
//			// 响应码为200成功
//			if (response.getStatusLine().getStatusCode() == 200) {
//				String data = EntityUtils.toString(response.getEntity(), "utf-8");
//				System.out.println(data.length());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				response.close();
//				httpClient.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//}
