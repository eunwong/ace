package com.huacainfo.ace.autocode.uf;

import com.huacainfo.ace.autocode.base.AutoCodeUtils;

public class AutoCode {
	public static void main(String[] args) throws Exception{
		AutoCodeUtils autoCodeUtils=new AutoCodeUtils("uf");
		Class<?> c=com.huacainfo.ace.uf.model.Personage.class;
		autoCodeUtils.init(c);
		/*autoCodeUtils.createVO(c);
		autoCodeUtils.createQVO(c);
		autoCodeUtils.createDAO(c);
		autoCodeUtils.createService(c);
		autoCodeUtils.createServiceImpl(c);
		autoCodeUtils.createAction(c);*/
		autoCodeUtils.createJsp(c);
		autoCodeUtils.createJsConfig(c);
		autoCodeUtils.createJsView(c);
		autoCodeUtils.createModel(c);
		autoCodeUtils.createJsController(c);
	}
}