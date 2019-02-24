package com.ha.test;

import org.junit.Test;
import static org.junit.Assert.*;

import java.net.URI;
import java.net.URL;

public class MainTest {

    @Test
    public void getContent() throws Exception {
        //http://www.lolcats.com/api/v1/users/index.html?name=32
        URI uri = new URI("http://www.lolcats.com");
        URL u = uri.toURL();
        u.getProtocol();
        u.getFile();        //부위지정자 전까지.
        u.getPath();        //쿼리 전까지
        u.getRef();         //부위지정자
        u.getQuery();
        u.getAuthority();   //기관
        u.toURI();
        Object obj = u.getContent();
        System.out.println(obj);
    }

    @Test
    public void 같은지비교() throws Exception {
        URL www = new URL("http://www.ibiblio.org/");
        URL ibiblio = new URL("http://ibiblio.org/");
        if(www.equals(ibiblio)){
            System.out.println("같다");
        }else{
            System.out.println("같지 않다");
        }
    }

    @Test
    public void URLtoString() throws Exception {
        URL naver = new URL("http://www.naver.com");
        System.out.println(naver.toString());
        System.out.println(naver.toExternalForm());
        assertEquals("", "", "");
    }
}
