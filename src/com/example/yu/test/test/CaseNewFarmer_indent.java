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
		// ����ҳ�����ת
		t("�ҵ�");
		t("�ҵĶ���");
		solo.drag(400, 400, 900, 500, 3);
		s();
		solo.drag(400, 400, 900, 500, 3);
		s();// ���»�鿴����
		t("������");
		solo.drag(400, 400, 900, 500, 3);
		s();// ���»�鿴����
		t("������");
		solo.drag(400, 400, 900, 500, 3);
		s();// ���»�鿴����
		showLog("���ջ�");
		t("���ջ�");
		if(solo.searchText("ȥ�򻯷�",1,false,true)){
			v("com.ksfc.newfarmer:id/my_login_sure");
			solo.goBack();//����ר��
			s();
			v("com.ksfc.newfarmer:id/my_login_cancel");
			solo.goBack();//����ר��
			s();	
		}
		t("�����");
		solo.goBack();
		s();

		// �ڴ�����ҳ���붩������
		v("com.ksfc.newfarmer:id/mine_button2");
		solo.drag(400, 400, 900, 600, 3);
		s();
		v("com.ksfc.newfarmer:id/ordering_item_img");

	
	}
	
}