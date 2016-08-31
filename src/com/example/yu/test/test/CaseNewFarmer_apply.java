package com.example.yu.test.test;


import com.example.yu.test.test.RunTestCase.*;
import com.robotium.solo.Solo;


public class CaseNewFarmer_apply extends BaseCase {

	public String tag = " CaseNewFarmer_apply";

	public static CaseNewFarmer_apply caseInstance(Solo solo1) {
		CaseNewFarmer_apply instance = new CaseNewFarmer_apply();
		instance.instance(solo1);
		return instance;
	}
	
	public void test_run(){
		newFarmer_business();
	}

	/**
	 * ��֤�ؼ�������
	 */
	public void newFarmer_business() {
		// ��½һ����û�������ؼ������̵��˺�
	//	login_sure(Config.pNum_null);
		t("�ҵ�");
		v("com.ksfc.newfarmer:id/head_View_bg");
		if (!(solo.searchText("�ؼ�������", 1, false, true))) {
			t("����");
			t("�ؼ�������");
		}
		v("com.ksfc.newfarmer:id/choose_type_Certified_ll");

		// ��û��ѡ�����������¾�ȥѡ��ֵ�
		v("com.ksfc.newfarmer:id/choice_town_layout");
		if (!solo.waitForText("����ѡ�����")) {
			showErrLog(tag + ":newFarmer_business():��û��ѡ�����������¾�ȥѡ��ֵ�");
		}
		// û����д�����ύ
		v("com.ksfc.newfarmer:id/choice_compelet");
		if (!solo.waitForText("��������Ϣ")) {
			showErrLog(tag + ":newFarmer_business():û����д�����ύ");
		}
		// �������ܳ���12λ�ַ�
		enter("com.ksfc.newfarmer:id/name_tv", getRandomString(16));
		if (getEditTextString("com.ksfc.newfarmer:id/name_tv").length() != 12) {
			showErrLog(tag + ":newFarmer_business():�������ܳ���12λ�ַ�");
		}
		// δ��д���֤��
		v("com.ksfc.newfarmer:id/choice_compelet");
		if (!solo.waitForText("��������Ϣ")) {
			showErrLog(tag + ":newFarmer_business(): δ��д���֤��");
		}
		// δ��д�ŵ�
		enter("com.ksfc.newfarmer:id/id_card_number_tv", getRandomIntString(18));
		v("com.ksfc.newfarmer:id/choice_compelet");
		if (!solo.waitForText("��������Ϣ")) {
			showErrLog(tag + ":newFarmer_business():δ��д�ŵ�");
		}
		// �ŵ겻�ܳ���40���ַ�
		enter("com.ksfc.newfarmer:id/store_name_tv", getRandomString(50));
		if (getEditTextString("com.ksfc.newfarmer:id/store_name_tv").length() != 40) {
			showErrLog(tag + ":newFarmer_business():�ŵ겻�ܳ���40���ַ�");
		}
		// δ��д��ϵ�绰
		v("com.ksfc.newfarmer:id/choice_compelet");
		if (!solo.waitForText("��������Ϣ")) {
			showErrLog(tag + ":newFarmer_business(): δ��д��ϵ�绰");
		}
		// δ��д����
		enter("com.ksfc.newfarmer:id/phone_tv", Config.pNum_err);
		v("com.ksfc.newfarmer:id/choice_compelet");
		if (!solo.waitForText("��������Ϣ")) {
			showErrLog(tag + ":newFarmer_business(): δ��д����");
		}
		// δ��д�ֵ�
		v("com.ksfc.newfarmer:id/choice_city_layout");
		solo.clickInList(1);
		s();
		solo.clickInList(getRandomInt(1, 12));
		s();
		solo.clickInList(getRandomInt(1, 5));
		s();
		v("com.ksfc.newfarmer:id/choice_compelet");
		if (!solo.waitForText("��������Ϣ")) {
			showErrLog(tag + ":newFarmer_business(): δ��д�ֵ�");
		}
		// δ��д��ϸ��ַ
		v("com.ksfc.newfarmer:id/choice_town_layout");
		solo.clickInList(getRandomInt(1, 7));
		v("com.ksfc.newfarmer:id/choice_compelet");
		if (!solo.waitForText("��������Ϣ")) {
			showErrLog(tag + ":newFarmer_business():δ��д��ϸ��ַ");
		}
		// ��ѡ�������ֵ��Ƿ�����
		v("com.ksfc.newfarmer:id/choice_city_layout");
		solo.clickInList(1);
		s();
		solo.clickInList(getRandomInt(1, 12));
		s();
		solo.clickInList(getRandomInt(1, 5));
		s();
		if (!getTextHintString("com.ksfc.newfarmer:id/choice_town_text")
				.equals("ѡ�����ڽֵ�������")) {
			showErrLog(tag + ":newFarmer_business():��ѡ�������ֵ��Ƿ�����");
		}
		//��ϸ��ַ���ܳ���60λ�ַ�
		v("com.ksfc.newfarmer:id/choice_town_layout");
		solo.clickInList(getRandomInt(1, 7));
		enter("com.ksfc.newfarmer:id/store_address_tv",getRandomString(70));
		if(getEditTextString("com.ksfc.newfarmer:id/store_address_tv").length()!=60){
			showErrLog(tag + ":newFarmer_business():��ϸ��ַ���ܳ���60λ�ַ�");
		}
		//��д��ʽ������ֻ���
		v("com.ksfc.newfarmer:id/choice_compelet");
		if (!solo.waitForText("�����ֻ��Ż������֤�����Ƿ���ȷ")) {
			showErrLog(tag + ":newFarmer_business():��д��ʽ������ֻ���");
		}
		//�ύ��ʽ��������֤��
		clear("com.ksfc.newfarmer:id/phone_tv");
		enter("com.ksfc.newfarmer:id/phone_tv", Config.pNum_err);
		clear("com.ksfc.newfarmer:id/id_card_number_tv");
		enter("com.ksfc.newfarmer:id/id_card_number_tv", getRandomIntString(6));
		v("com.ksfc.newfarmer:id/choice_compelet");
		if (!solo.waitForText("�����ֻ��Ż������֤�����Ƿ���ȷ")) {
			showErrLog(tag + ":newFarmer_business():�ύ��ʽ��������֤��");
		}
		/**
		 * ���ڹ��̲����棬Ϊ�˷����β��ԣ��ʲ�������ȷ��ʽ�ı���
		 */
		g();
		g();
		t("��ҳ");
	}
}