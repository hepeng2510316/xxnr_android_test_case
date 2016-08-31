package com.example.yu.test.test;

import android.view.View;
import com.example.yu.test.test.RunTestCase.*;
import com.robotium.solo.Solo;

public class CaseNewFarmer_myself extends BaseCase {

	public String tag = " CaseNewFarmer_myself";

	public static CaseNewFarmer_myself caseInstance(Solo solo1) {
		CaseNewFarmer_myself instance = new CaseNewFarmer_myself();
		instance.instance(solo1);
		return instance;
	}
	
	public void test_run(){
	//	newFarmer_information();
		newFarmer_password();
	}

	/**
	 * ������Ϣ
	 */
	public void newFarmer_information() {
		login_sure(Config.pNum_reg);
		t("�ҵ�");
		v("com.ksfc.newfarmer:id/head_View_bg");
		// �޸�ͷ��
		v("com.ksfc.newfarmer:id/header_image_ll");
		if (!solo.searchText("�����ϴ�", 1, false, true)) {
			showErrLog(tag + ":newFarmer_information():�޸�ͷ��");
		}
		t("ȡ��");

		/**
		 * �޸��ǳ�
		 */
		t("�ҵ��ǳ�");
		// δ�޸��ǳƣ����水ť���ɵ��
		View view = solo.getView("com.ksfc.newfarmer:id/name_submit_tv");
		if (view.isEnabled()) {
			showErrLog(tag + ":newFarmer_information():δ�޸��ǳƣ����水ť���ɵ��");
		}
		// �����ǳƵ�ǰ��������ǳƱ���
		clear("com.ksfc.newfarmer:id/et_modify");
		t("����");
		if (!solo.waitForText("������������Ϣ")) {
			showErrLog(tag + ":newFarmer_information():�����ǳƵ�ǰ��������ǳ�");
		}
		// �޸��ǳƳ���12λ�ַ�
		enter("com.ksfc.newfarmer:id/et_modify", getRandomString(16));
		String nicheng = getEditTextString("com.ksfc.newfarmer:id/et_modify");
		if (nicheng.length() != 12) {
			showErrLog(tag + ":newFarmer_information():�޸��ǳƳ���12λ�ַ�");
		}
		// �����ǳ�
		t("����");
		if (!solo.waitForText("����ɹ�")) {
			showErrLog(tag + ":newFarmer_information():�����ǳ�");
		}

		/**
		 * �޸�����
		 */
		// δ�޸����������水ť���ɵ��
		t("����");
		view = solo.getView("com.ksfc.newfarmer:id/name_submit_tv");
		if (view.isEnabled()) {
			showErrLog(tag + ":newFarmer_information():δ�޸����������水ť���ɵ��");
		}
		// ����Ϊ��ʱ����
		clear("com.ksfc.newfarmer:id/et_modify");
		t("����");
		if (!solo.waitForText("������������Ϣ")) {
			showErrLog(tag + ":newFarmer_information(): ����Ϊ��ʱ����");
		}
		// �޸���������12λ�ַ�
		enter("com.ksfc.newfarmer:id/et_modify", getRandomString(17));
		String name = getEditTextString("com.ksfc.newfarmer:id/et_modify");
		if (name.length() != 12) {
			showErrLog(tag + ":newFarmer_information():�޸���������12λ�ַ�");
		}
		// ��������
		t("����");
		if (!solo.waitForText("����ɹ�")) {
			showErrLog(tag + ":newFarmer_information():��������");
		}

		/**
		 * �޸��Ա�
		 */
		String sex = getTextViewString("com.ksfc.newfarmer:id/sex_tv");
		t("�Ա�");
		// ȡ��ѡ���Ա�
		v("com.ksfc.newfarmer:id/btn_cancel");
		String sex_change = getTextViewString("com.ksfc.newfarmer:id/sex_tv");
		if (!sex.equals(sex_change)) {
			showErrLog(tag + ":newFarmer_information():ȡ��ѡ���Ա�");
		}
		// ���Ա��޸�Ϊ��
		t("�Ա�");
		v("com.ksfc.newfarmer:id/btn_sure");
		if (!solo.waitForText("����ɹ�")) {
			showErrLog(tag + ":newFarmer_information():���Ա��޸�Ϊ��");
		}
		sex_change = getTextViewString("com.ksfc.newfarmer:id/sex_tv");
		if (!sex_change.equals("��")) {
			showErrLog(tag + ":newFarmer_information():���Ա��޸�Ϊ��");
		}
		// ���Ա��޸�ΪŮ
		t("�Ա�");
		v("com.ksfc.newfarmer:id/btn_normal");
		if (!solo.waitForText("����ɹ�")) {
			showErrLog(tag + ":newFarmer_information():���Ա��޸�ΪŮ");
		}
		sex_change = getTextViewString("com.ksfc.newfarmer:id/sex_tv");
		if (!sex_change.equals("Ů")) {
			showErrLog(tag + ":newFarmer_information():���Ա��޸�ΪŮ");
		}

		/**
		 * �û����ڵ���
		 */
		// δ�޵��������水ť���ɵ��
		t("���ڵ���");
		view = solo.getView("com.ksfc.newfarmer:id/name_submit_tv");
		if (view.isEnabled()) {
			showErrLog(tag + ":newFarmer_information():δ�޵��������水ť���ɵ��");
		}

		// ������ȷ��д��ַ������޸ĵ������鿴�ֵ��Ƿ���֮�仯
		t("���ڵ���");
		v("com.ksfc.newfarmer:id/choice_city_layout");
		solo.clickInList(1);
		solo.clickInList(getRandomInt(1, 12));
		solo.clickInList(getRandomInt(1, 4));
		if (!getTextHintString("com.ksfc.newfarmer:id/choice_town_text")
				.equals("��ѡ��ֵ�")) {
			showErrLog(tag
					+ ":newFarmer_information():������ȷ��д��ַ������޸ĵ������鿴�ֵ��Ƿ���֮�仯");
		}
		// δ��д�ֵ�����±���
		t("����");
		if (!solo.waitForText("��ַ����Ϊ��")) {
			showErrLog(tag + ":newFarmer_information():δ��д�ֵ�����±���");
		}
		//��ȷ�������
		v("com.ksfc.newfarmer:id/choice_town_layout");
		solo.clickInList(getRandomInt(1, 5));
		t("����");
		if (!solo.waitForText("����ɹ�")) {
			showErrLog(tag + ":newFarmer_information():��ȷ�������");
		}

		/**
		 * �����û�����
		 */
		//��ͨ�û�
		t("����");
		t("��ͨ�û�");
		if (!solo.waitForText("����ɹ�")) {
			showErrLog(tag + ":newFarmer_information():��ͨ�û�");
		}
		if(!getTextViewString("com.ksfc.newfarmer:id/type_tv").equals("��ͨ�û�")){
			showErrLog(tag + ":newFarmer_information():��ͨ�û�");
		}
		//��ũ������
		t("����");
		t("��ũ������");
		if (!solo.waitForText("����ɹ�")) {
			showErrLog(tag + ":newFarmer_information():��ũ������");
		}
		if(!getTextViewString("com.ksfc.newfarmer:id/type_tv").equals("��ũ������")){
			showErrLog(tag + ":newFarmer_information():��ũ������");
		}
		//�ؼ�������
		t("����");
		t("�ؼ�������");
		if (!solo.waitForText("����ɹ�")) {
			showErrLog(tag + ":newFarmer_information():�ؼ�������");
		}
		if(!getTextViewString("com.ksfc.newfarmer:id/type_tv").equals("�ؼ�������")){
			showErrLog(tag + ":newFarmer_information():�ؼ�������");
		}
		//��������֤���ؼ������̿��Բ鿴��֤��Ϣ
		if(!solo.searchText("�鿴��֤��Ϣ")){
			showErrLog(tag + ":newFarmer_information():��������֤���ؼ������̿��Բ鿴��֤��Ϣ");
		}
		//�鿴��֤��Ϣ
		v("com.ksfc.newfarmer:id/choose_type_Certified_ll");
		if(!solo.searchText("��ϸ��ַ")){
			showErrLog(tag + ":newFarmer_information():�鿴��֤��Ϣ");
		}
		g();
		//δ�����ؼ�������֤���˻�
		t("�˳���¼");
		solo.clickOnButton("ȷ��");
		t("��ҳ");
		login_sure(Config.pNum_null);
		t("�ҵ�");
		v("com.ksfc.newfarmer:id/head_View_bg");
		if(!solo.searchText("���Ϊ����ũ�˵��ؼ����㣿ȥ������֤��")){
			showErrLog(tag + ":newFarmer_information():δ�����ؼ�������֤���˻�");
		}
		//�������վ��֤ҳ��
		v("com.ksfc.newfarmer:id/choose_type_Certified_ll");
		if(!solo.searchText("����վ��֤")){
			showErrLog(tag + ":newFarmer_information():�������վ��֤ҳ��");
		}
		g();
		g();
	}

	/**
	 * �޸�����
	 */

	public void newFarmer_password() {
	//	login_sure(Config.pNum_reg);
		t("�ҵ�");
		v("com.ksfc.newfarmer:id/head_View_bg");
		t("�޸�����");
		// δ�����κ�����
		t("���");
		if (!solo.waitForText("�����������")) {
			showErrLog(tag + ":newFarmer_password():δ�����κ�����");
		}
		// ֻ���������
		enter("com.ksfc.newfarmer:id/backedit1",Config.pwd_err);
		t("���");
		if (!solo.waitForText("������������")) {
			showErrLog(tag + ":newFarmer_password():ֻ���������");
		}
		// δ����ȷ������
		enter("com.ksfc.newfarmer:id/backnewpassword", Config.pwd_cur);
		t("���");
		if (!solo.waitForText("������ȷ������")) {
			showErrLog(tag + ":newFarmer_password():δ����ȷ������");
		}
		// �������ľ�����
		enter("com.ksfc.newfarmer:id/confimPasword", Config.pwd_cur);
		t("���");
		if (!solo.waitForText("�������������")) {
			showErrLog(tag + ":newFarmer_password():�������ľ�����");
		}
		// ������¾�����һ��
		clear("com.ksfc.newfarmer:id/backedit1");
		enter("com.ksfc.newfarmer:id/backedit1", Config.pwd_cur);
		t("���");
		if (!solo.waitForText("������������벻��һ��")) {
			showErrLog(tag + ":newFarmer_password():������¾�����һ��");
		}
		// �������ȷ�����벻һ��
		clear("com.ksfc.newfarmer:id/backnewpassword");
		enter("com.ksfc.newfarmer:id/backnewpassword", Config.pwd_err);
		t("���");
		if (!solo.waitForText("�������벻һ�£�����������")) {
			showErrLog(tag + ":newFarmer_password(): �������ȷ�����벻һ��");
		}
		//��������ȷ������С��6λ
		clear("com.ksfc.newfarmer:id/confimPasword");
		enter("com.ksfc.newfarmer:id/confimPasword", Config.pwd_err);
		t("���");
		if (!solo.waitForText("�����費С��6λ")) {
			showErrLog(tag + ":newFarmer_password(): ��������ȷ������С��6λ");
		}
		//�޸�����ɹ�
		clear("com.ksfc.newfarmer:id/backnewpassword");
		enter("com.ksfc.newfarmer:id/backnewpassword", Config.new_pwd);
		clear("com.ksfc.newfarmer:id/confimPasword");
		enter("com.ksfc.newfarmer:id/confimPasword", Config.new_pwd);
		t("���");
		if (!solo.waitForText("�޸�����ɹ�")) {
			showErrLog(tag + ":newFarmer_password(): �޸�����ɹ�");
		}
		//�Ļ�ԭ���룬�����´β���
		clear("com.ksfc.newfarmer:id/login_layout_phone");
		enter("com.ksfc.newfarmer:id/login_layout_phone",Config.pNum_reg);
		enter("com.ksfc.newfarmer:id/login_layoutpassword",Config.new_pwd);
		t("ȷ�ϵ�¼");
		v("com.ksfc.newfarmer:id/head_View_bg");
		t("�޸�����");
		enter("com.ksfc.newfarmer:id/backedit1",Config.new_pwd);
		enter("com.ksfc.newfarmer:id/backnewpassword", Config.pwd_cur);
		enter("com.ksfc.newfarmer:id/confimPasword", Config.pwd_cur);
		t("���");
	}

	
}