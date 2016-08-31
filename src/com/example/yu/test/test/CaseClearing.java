package com.example.yu.test.test;

import com.example.yu.test.test.RunTestCase.*;
import com.robotium.solo.Solo;
import com.squareup.spoon.Spoon;

import android.view.View;

public class CaseClearing extends BaseCase {
	public static String tag = "CaseClearing";

	public static CaseClearing caseInstance(Solo solo1) {
		CaseClearing instance = new CaseClearing();
		instance.instance(solo1);
		return instance;
	}

	public void test_run() {
	//	delivery();
	//	net();
		separate();
		
	}

	/**
	 * ���͵���
	 */
	public void delivery() {

		login_sure(Config.pNum_reg);
		t("���ﳵ");
		// ���ﳵ�����֧�����͵�������Ʒ�����뵽�ύ����ҳ��
		if (!solo.searchText("ȥ�򻯷�", 1, false, true)) {
			v("com.ksfc.newfarmer:id/btn_check_all");
			t("�༭");
			v("com.ksfc.newfarmer:id/ordering_go_bt");
			solo.clickOnButton("��");
		}

		t("ȥ�򻯷�");
		solo.clickInList(2);
		t("���빺�ﳵ");
		t("ȷ��");
		v("com.ksfc.newfarmer:id/title_right_img");
		v("com.ksfc.newfarmer:id/btn_check_all");
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		v("com.ksfc.newfarmer:id/deliveries_way_home");// ѡ�����͵���

		/**
		 * �ջ���ַΪ��ʱ�ύ����
		 */
		if (solo.searchText("����ջ���ַ", 1, false, true)) {
			v("com.ksfc.newfarmer:id/ordering_go_bt");
			if (!solo.waitForText("�ջ���ַ����Ϊ��")) {
				showErrLog(tag + ":delivery():û���ջ���ַʱ����ύ����");
			}
		} else {
			v("com.ksfc.newfarmer:id/address_shouhuo_ll");
			while (!solo.searchText("����û���ջ���ַŶ�����һ����~", 1, false, true)) {
				v("com.ksfc.newfarmer:id/delete_address_img");
				v("com.ksfc.newfarmer:id/btn_sure");
			}
			g();
			v("com.ksfc.newfarmer:id/ordering_go_bt");
			if (!solo.waitForText("�ջ���ַ����Ϊ��")) {
				showErrLog(tag + ":delivery():û���ջ���ַʱ����ύ����");
			}
		}

		/**
		 * ����ջ���ַ
		 */
		v("com.ksfc.newfarmer:id/add_address_shouhuo_ll");
		v("com.ksfc.newfarmer:id/title_right_text");
		// δ��д�ջ��������ͱ���
		clear("com.ksfc.newfarmer:id/shouhuo_name");
		t("����");
		if (!solo.waitForText("�������ջ�������")) {
			showErrLog(tag + ":delivery():δ��д�ջ��������ͱ���");
		}
		// δ��д�ֻ���
		enter("com.ksfc.newfarmer:id/shouhuo_name", getRandomString(6));
		clear("com.ksfc.newfarmer:id/shouhuo_tel");
		t("����");
		if (!solo.waitForText("�������ֻ�����")) {
			showErrLog(tag + ":delivery():δ��д�ֻ���");
		}
		// ��д������ֻ���
		enter("com.ksfc.newfarmer:id/shouhuo_tel", Config.pNum_err);
		t("����");
		if (!solo.waitForText("��������ȷ���ֻ�����")) {
			showErrLog(tag + ":delivery():��д������ֻ���");
		}
		// ��д��ȷ���ֻ��ţ�����û����д��ַ
		clear("com.ksfc.newfarmer:id/shouhuo_tel");
		enter("com.ksfc.newfarmer:id/shouhuo_tel", Config.pNum_reg);
		t("����");
		if (!solo.waitForText("��ѡ�����")) {
			showErrLog(tag + ":delivery():��д��ȷ���ֻ��ţ�����û����д��ַ");
		}
		// ѡ������к����������ѡ����У��������Ƿ���֮����
		v("com.ksfc.newfarmer:id/choice_city_layout");
		solo.clickInList(1);
		solo.clickInList(getRandomInt(1, 12));
		solo.clickInList(getRandomInt(1, 7));
		v("com.ksfc.newfarmer:id/choice_town_layout");
		solo.clickInList(getRandomInt(1, 5));
		v("com.ksfc.newfarmer:id/choice_city_layout");
		solo.clickInList(1);
		solo.clickInList(getRandomInt(1, 12));
		solo.clickInList(getRandomInt(1, 7));
		if (!getTextHintString("com.ksfc.newfarmer:id/choice_town_text")
				.contains("��ѡ������")) {
			showErrLog(tag + ":delivery():ѡ������к����������ѡ����У��������Ƿ���֮����");
		}
		// δ��д��ϸ��ַ
		t("����");
		if (!solo.waitForText("������������ϸ��ַ")) {
			showErrLog(tag + ":delivery():δ��д��ϸ��ַ");
		}
		// �����ַ������ȳ���50����ϸ��ַ
		enter("com.ksfc.newfarmer:id/choice_detail_room_edit",
				getRandomString(55));
		if (getEditTextString("com.ksfc.newfarmer:id/choice_detail_room_edit")
				.length() != 50) {
			showErrLog(tag + ":delivery():�����ַ������ȳ���50����ϸ��ַ");
		}
		// �ɹ������ַ
		t("����");
		if (!solo.waitForText("�ɹ������˵�ַ")) {
			showErrLog(tag + ":delivery():�ɹ������ַ");
		}

		/**
		 * �༭�ջ���ַ
		 */
		// �ڱ༭��ַҳ��ɾ����ַ
		v("com.ksfc.newfarmer:id/edit_address_img");
		v("com.ksfc.newfarmer:id/choose_address_delete");
		v("com.ksfc.newfarmer:id/btn_sure");
		if (!solo.searchText("����û���ջ���ַŶ�����һ����~", 1, false, true)) {
			showErrLog(tag + ":delivery():�ڱ༭��ַҳ��ɾ����ַ");
		}
		addAddress();
		// ���ջ���ַҳ��ɾ����ַ
		v("com.ksfc.newfarmer:id/delete_address_img");
		v("com.ksfc.newfarmer:id/btn_sure");
		if(!solo.searchText("����û���ջ���ַŶ�����һ����~", 1, false, true)){
			showErrLog(tag + ":delivery():�ڱ༭��ַҳ��ɾ����ַ");
		}
		addAddress();
		g();
		// �ɹ��ύ����
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		solo.assertCurrentActivity(tag + ":delivery():�ɹ��ύ����", "PaywayActivity");
		g();
	}

	/**
	 * ��������
	 */
	public void net() {
		t("���ﳵ");
		// ���ﳵ��������㲻ͬ����Ʒ�����Ƿ�����ѡ������ʾ
		if (!solo.searchText("ȥ������", 1, false, true)) {
			v("com.ksfc.newfarmer:id/btn_check_all");
			t("�༭");
			v("com.ksfc.newfarmer:id/ordering_go_bt");
			solo.clickOnButton("��");
		}
		t("ȥ�򻯷�");
		solo.clickInList(1);
		t("���빺�ﳵ");
		t("2-2-2");
		t("40",2);
		t("ȷ��");
		g();
		g();
		t("��ҳ");
		t("����ר��");
		solo.clickInList(2);
		t("���빺�ﳵ");
		t("ȷ��");
		v("com.ksfc.newfarmer:id/title_right_img");
		v("com.ksfc.newfarmer:id/btn_check_all");
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		if (!solo.searchText("��ѡ�����Ʒ������ͬһ���������ᣬ�뷵�ع��ﳵ����ѡ��", 1, false, true)) {
			showErrLog(tag + ":net():���ﳵ��������㲻ͬ����Ʒ�����Ƿ�����ѡ������ʾ");
		}
		// ���ﳵ��������㲻ͬ����Ʒ�����Ƿ����ύ����
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		if (!solo.waitForText("��ѡ�����Ʒ������ͬһ���������ᣬ�뷵�ع��ﳵ����ѡ��")) {
			showErrLog(tag + ":net():���ﳵ��������㲻ͬ����Ʒ�����Ƿ����ύ����");
		}
		// �����ﳵ����ӳ���ѡ�������ȥ����
		g();
		if (!solo.searchText("ȥ������", 1, false, true)) {
			v("com.ksfc.newfarmer:id/btn_check_all");
			t("�༭");
			v("com.ksfc.newfarmer:id/ordering_go_bt");
			solo.clickOnButton("��");
		}
		t("ȥ������");
		solo.clickInList(1);
		s();
		t("���빺�ﳵ");
		t("1.5L �ֶ���MT��");
		t("������");
		t("�ſ��");
		t("ȷ��");
		v("com.ksfc.newfarmer:id/title_right_img");
		solo.clickOnCheckBox(0);
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		solo.assertCurrentActivity(tag + ":net():�����ﳵ����ӳ���ѡ�������ȥ����",
				"AddOrderActivity");

		// û��ѡ�������������ύ����
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		if (!solo.waitForText("��ѡ����������")) {
			showErrLog(tag + ":net():û��ѡ�������������ύ����");
		}

		/**
		 * �����
		 */
		// �ж���δѡ��������������£�ȷ����ť�Ƿ��ܹ����
		v("com.ksfc.newfarmer:id/select_state_address_ll_state");
		View view = solo.getView("com.ksfc.newfarmer:id/save_userInfo");
		if (view.isEnabled()) {
			showErrLog(tag + ":net():�ж���δѡ��������������£�ȷ����ť�Ƿ��ܹ����");
		}
		v("com.ksfc.newfarmer:id/state_city_rel");
		solo.clickInList(getRandomInt(2, 4));
		View view2 = solo.getView("com.ksfc.newfarmer:id/save_userInfo");
		if (view2.isEnabled()) {
			showErrLog(tag + ":net():�ж���δѡ��������������£�ȷ����ť�Ƿ��ܹ����");
		}
		v("com.ksfc.newfarmer:id/state_county_rel");
		solo.clickInList(2);
		View view3 = solo.getView("com.ksfc.newfarmer:id/save_userInfo");
		if (view3.isEnabled()) {
			showErrLog(tag + ":net():�ж���δѡ��������������£�ȷ����ť�Ƿ��ܹ����");
		}

		// ����һ����ַ��Ϊȫ��������������һ����ַ�Ƿ��Ϊȫ������
		v("com.ksfc.newfarmer:id/state_city_rel");
		solo.clickInList(1);
		String s = getTextViewString("com.ksfc.newfarmer:id/state_county_text");
		if (!s.equals("ȫ������")) {
			showErrLog(tag + ":net():����һ����ַ��Ϊȫ��������������һ����ַ�Ƿ��Ϊȫ������");
		}
		v("com.ksfc.newfarmer:id/state_city_rel");
		solo.clickInList(2);
		v("com.ksfc.newfarmer:id/state_province_rel");
		solo.clickInList(1);
		String s2 = getTextViewString("com.ksfc.newfarmer:id/state_city_text");
		if (!s2.equals("ȫ������")) {
			showErrLog(tag + ":net():����һ����ַ��Ϊȫ��������������һ����ַ�Ƿ��Ϊȫ������");
		}
		String s3 = getTextViewString("com.ksfc.newfarmer:id/state_county_text");
		if (!s3.equals("ȫ������")) {
			showErrLog(tag + ":net():����һ����ַ��Ϊȫ��������������һ����ַ�Ƿ��Ϊȫ������");
		}

		// ѡ��ĳһ�������󷵻���һҳ
		solo.clickInList(1);
		v("com.ksfc.newfarmer:id/save_userInfo");

		/**
		 * ѡ���ջ���ҳ��
		 */
		// δ��д�ջ��˺��ֻ��ŵ�����£�����ȷ����ť�Ƿ��ܵ��
		v("com.ksfc.newfarmer:id/select_state_address_ll_person");
		View view4 = solo.getView("com.ksfc.newfarmer:id/name_submit_tv");
		if (view4.isEnabled()) {
			showErrLog(tag + ":net():δ��д�ջ��˺��ֻ��ŵ�����£�����ȷ����ť�Ƿ��ܵ��");
		}
		//�ջ����������ܳ���12λ�ַ�
		enter("com.ksfc.newfarmer:id/shouhuo_name",getRandomString(15));
		if(getEditTextString("com.ksfc.newfarmer:id/shouhuo_name").length()!=12){
			showErrLog(tag+"net():�ջ����������ܳ���12λ�ַ�");
		}
		// ��д��ʽ������ֻ���
		enter("com.ksfc.newfarmer:id/shouhuo_tel", Config.pNum_err);
		t("ȷ��");
		if (!solo.waitForText("��������ȷ���ֻ�����")) {
			showErrLog(tag + ":net():��д��ʽ������ֻ���");
		}
		// ��д��ʽ��ȷ���ֻ��Ų�����
		clear("com.ksfc.newfarmer:id/shouhuo_tel");
		enter("com.ksfc.newfarmer:id/shouhuo_tel", Config.pNum_reg);
		t("ȷ��");

		// ������ʷ�ջ���ѡ���ջ���
		v("com.ksfc.newfarmer:id/select_state_address_ll_person");
		solo.clickInList(3);
		// �ɹ��ύ����
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		solo.assertCurrentActivity(tag + ":net():�ɹ��ύ����", "PaywayActivity");
		g();
		t("��ҳ");
	}
	
	/**
	 * �����Ĳ��
	 */
	public void separate(){
		login_sure(Config.pNum_reg);
		t("���ﳵ");
		if (!solo.searchText("ȥ�򻯷�", 1, false, true)) {
			v("com.ksfc.newfarmer:id/btn_check_all");
			t("�༭");
			v("com.ksfc.newfarmer:id/ordering_go_bt");
			solo.clickOnButton("��");
		}
		t("ȥ�򻯷�");
		solo.clickInList(2);
		t("���빺�ﳵ");
		t("ȷ��");
		solo.clickInList(5);
		t("���빺�ﳵ");
		t("ȷ��");
		v("com.ksfc.newfarmer:id/title_right_img");
		v("com.ksfc.newfarmer:id/btn_check_all");
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		v("com.ksfc.newfarmer:id/deliveries_way_home");
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		if(!solo.searchText("ѡ��֧������",1,false,true)){
			showErrLog(tag+":separate():�����Ĳ��");
		}
		//ѡ������һ������ȥ֧��
		v("com.ksfc.newfarmer:id/go_to_pay");
		solo.assertCurrentActivity(tag + ":separate():ѡ������һ������ȥ֧��", "PaywayActivity");
	}

	/**
	 * �ڻ���ַҳ����ӵ�ַ
	 */
	public void addAddress() {
		v("com.ksfc.newfarmer:id/title_right_text");
		clear("com.ksfc.newfarmer:id/shouhuo_name");
		enter("com.ksfc.newfarmer:id/shouhuo_name", getRandomString(6));
		clear("com.ksfc.newfarmer:id/shouhuo_tel");
		enter("com.ksfc.newfarmer:id/shouhuo_tel", Config.pNum_reg);
		v("com.ksfc.newfarmer:id/choice_city_layout");
		solo.clickInList(1);
		int x = 1 + (int) (Math.random() * 12);
		solo.clickInList(x);
		int y = 1 + (int) (Math.random() * 5);
		solo.clickInList(y);
		enter("com.ksfc.newfarmer:id/choice_detail_room_edit", getRandomString(10));
		t("����");
	}

}
