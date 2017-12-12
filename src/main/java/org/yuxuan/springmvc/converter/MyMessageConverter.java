package org.yuxuan.springmvc.converter;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;
import org.yuxuan.springmvc.domain.DemoObj;
/**
 * 继承AbstractHttpMessageConverter类实现自定义HttpMessageConverter
 *
 * @author yuxuan.han
 */
public class MyMessageConverter extends AbstractHttpMessageConverter<DemoObj> {

	public MyMessageConverter() {
		//	新建自定义媒体类型x-wisely
		super(new MediaType("application", "x-wisely", Charset.forName("UTF-8")));
	}
	
	/**
	 * 重写readInternal方法，处理请求的数据。
	 */
	@Override
	protected DemoObj readInternal(Class<? extends DemoObj> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		String temp = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("UTF-8"));
		//	处理由"-"隔开的数据，并转换成DemoObj对象
		String[] tempArr = temp.split("-");
		return new DemoObj(new Long(tempArr[0]), tempArr[1]);
	}
	
	/**
	 * 表示只处理DemoObj这个类
	 */
	@Override
	protected boolean supports(Class<?> clazz) {
		return DemoObj.class.isAssignableFrom(clazz);
	}

	/**
	 * 重新writeInternal，处理如何输出到response
	 */
	@Override
	protected void writeInternal(DemoObj obj, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		String out = "hello: " + obj.getId() + "-" + obj.getName();
		outputMessage.getBody().write(out.getBytes());
	}

}
