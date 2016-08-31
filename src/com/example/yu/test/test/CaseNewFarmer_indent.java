package com.example.yu.test.test;

import android.util.Log;
import com.example.yu.test.test.RunTestCase.*;
import com.robotium.solo.Solo;

import android.widget.EditText;

public class CaseNewFarmer_indent extends BaseCase {
	
	public String tag = " CaseNewFarmer_indent";
	
	public static CaseMyNewFarmer caseInstance(Solo solo1) {
		CaseMyNewFarmer  instance=new CaseMyNewFarmer();
		instance.instance(solo1);
		return instance;	
		}
		
	public void test_newFarmer_indent() {
		login_sure(Config.pNum_err);
		// 订单页面的跳转
		t("我的");
		t("我的订单");
		solo.drag(400, 400, 900, 500, 3);
		s();
		solo.drag(400, 400, 900, 500, 3);
		s();// 向下活动查看订单
		t("待付款");
		solo.drag(400, 400, 900, 500, 3);
		s();// 向下活动查看订单
		t("待发货");
		solo.drag(400, 400, 900, 500, 3);
		s();// 向下活动查看订单
		showLog("待收货");
		t("待收货");
		if(solo.searchText("去买化肥",1,false,true)){
			v("com.ksfc.newfarmer:id/my_login_sure");
			solo.goBack();//化肥专场
			s();
			v("com.ksfc.newfarmer:id/my_login_cancel");
			solo.goBack();//汽车专场
			s();	
		}
		t("已完成");
		solo.goBack();
		s();

		// 在待付款页进入订单详情
		v("com.ksfc.newfarmer:id/mine_button2");
		solo.drag(400, 400, 900, 600, 3);
		s();
		v("com.ksfc.newfarmer:id/ordering_item_img");

	
	}
	
}