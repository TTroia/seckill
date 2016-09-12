package org.seckill.web;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author changhongyuan
 * @date 2016年9月10日09:27:10
 */
@Controller
public class GetCookieController {

    @RequestMapping(value = "/getIn")
    public String getIn() {
        return "/getRequest/getRequest";
    }

    @RequestMapping(value = "/getRequest")
    public String getRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("Origin_1:" + request.getAttribute("Origin"));
        request.setAttribute("Origin", "http://user.qzone.qq.com");
        System.out.println("Origin_2:" + request.getAttribute("Origin"));
        response.setHeader("Origin", "http://user.qzone.qq.com");
        response.sendRedirect("redirect:http://user.qzone.qq.com/775155797/infocenter");
        //return "redirect:http://user.qzone.qq.com/384095855/infocenter?via=toolbar";
        return null;

        /*String res = "";
        HttpURLConnection conn = null;
        String BOUNDARY = "---------------------------123821742118716";
        try {
            URL url = new URL("http://www.baidu.com");
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
            conn.setRequestProperty("Content-Type",
                    "multipart/form-data; boundary=" + BOUNDARY);

            OutputStream out = new DataOutputStream(conn.getOutputStream());
            out.flush();
            out.close();

            // 读取返回数据
            StringBuffer strBuf = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                strBuf.append(line).append("\n");
            }
            res = strBuf.toString();
            reader.close();
            reader = null;
        }catch (Exception e){

        }*/
    }

    /**
     * 后台代理实现思路
     * 1.用HttpClient模拟浏览器请求一次www.qq.com
     * 2.将返回的网页内容添加进response中返回到本地页面
     * 3.将ajax返回值写入到iframe中，并试着使ref或者origin成为qq.com
     * 4.尝试读取cookies
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/proxy")
    public String Proxy(HttpServletResponse response) throws Exception {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("http://www.baidu.com/");
        CloseableHttpResponse httpResponse = httpclient.execute(httpget);
        HttpEntity entity = httpResponse.getEntity();
        String html = EntityUtils.toString(entity, "UTF-8");
        String html2 = html.replaceAll("\"", "'").replaceAll("\r\n", " ");
        System.out.println(html2);

        response.setHeader("Origin","http://www.qq.com");


        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write("{\"html\":\"" + html2+ "\"}");
        response.getWriter().flush();
        response.getWriter().close();

        System.gc();
        httpclient.close();
        return null;
    }
}
