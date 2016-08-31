package com.example.yu.test.test;

import com.example.yu.test.test.RunTestCase.*;
import com.robotium.solo.Solo;

public class CaseFunction extends BaseCase {

	public String tag = " CaseFunction";

	public static CaseFunction caseInstance(Solo solo1) {
		CaseFunction instance = new CaseFunction();
		instance.instance(solo1);
		return instance;
	}

	// ����
	public void test_run() {
		register();
		loginTest();
		forgetPassword();
	}

	/**
	 * ע��ҳ��
	 */
	public void register() {
		// ����ע�����
		login();
		t("����ע��");
		// δ��д�ֻ���
		t("����ע��");
		if (!solo.waitForText("�������ֻ���")) {
			showErrLog(tag + ":register() :δ��д�ֻ���");
		}

		// ��ע����ֻ���
		enter(("com.ksfc.newfarmer:id/backedit1"), Config.pNum_reg);
		t("��ѻ�ȡ��֤��");
		if (!solo.waitForText("���ֻ�����ע�ᣬ����������")) {
			showErrLog(tag + ":register() :��ע����ֻ���");
		}

		// ��ʽ������ֻ���
		clear(("com.ksfc.newfarmer:id/backedit1"));
		enter(("com.ksfc.newfarmer:id/backedit1"), Config.pNum_err);
		t("��ѻ�ȡ��֤��");
		if (!solo.waitForText("��������ȷ���ֻ���")) {
			showErrLog(tag + ":register() :��ʽ������ֻ���");
		}
		// ��Ҫ��дͼ����֤�룬����ͼ����֤�봰��
		clear(("com.ksfc.newfarmer:id/backedit1"));
		enter(("com.ksfc.newfarmer:id/backedit1"), Config.pNum_unReg);
		v("com.ksfc.newfarmer:id/backgetVerificationCode");
		if (!solo.searchText("��ȫ��֤", true)) {
			g();
			t("�������룿");
			enter(("com.ksfc.newfarmer:id/backedit1"), Config.pNum_reg);
			v("com.ksfc.newfarmer:id/backgetVerificationCode");
		}
		if (!solo.searchText("��ȫ��֤", true)) {
			showErrLog(tag + ": register():��Ҫ��дͼ����֤�룬����ͼ����֤�봰��");
		}
		// û����дͼ����֤��
		solo.clickOnButton("ȷ��");
		if (!solo.searchText("������ͼ����֤��", true)) {
			showErrLog(tag + ":register() :û����дͼ����֤��");
		}
		// ͼ����֤�����
		enter("com.ksfc.newfarmer:id/sms_auth_code_et", "123");
		solo.clickOnButton("ȷ��");
		if (!solo.searchText("ͼ����֤�����", true)) {
			showErrLog(tag + ":register() :ͼ����֤�����");
		}
		solo.clickOnButton("ȡ��");
		// δ��д��֤��
		t("����ע��");
		if (!solo.waitForText("��������֤��")) {
			showErrLog(tag + ":register() :δ��д��֤��");
		}
		// δ��д����
		enter(("com.ksfc.newfarmer:id/backyanzhengma"), "1111");
		t("����ע��");
		if (!solo.waitForText("����������")) {
			showErrLog(tag + ":register() :δ��д����");
		}
		// δ��дȷ������
		enter(("com.ksfc.newfarmer:id/backnewpassword"), "11111");// �������5λ��������
		t("����ע��");
		if (!solo.waitForText("������ȷ������")) {
			showErrLog(tag + ":register() :δ��дȷ������");
		}
		// �����ȷ�����������λ
		enter(("com.ksfc.newfarmer:id/confimPasword"), "11111");// �������5λ����ȷ������
		t("����ע��");
		if (!solo.waitForText("���볤�Ȳ�С��6λ")) {
			showErrLog(tag + ":register() :�����ȷ�����������λ");
		}
		// ������ȷ�����벻һ��
		clear("com.ksfc.newfarmer:id/backnewpassword");
		enter(("com.ksfc.newfarmer:id/backnewpassword"), Config.pwd_cur);// ���������ȷ��6λ����
		t("����ע��");
		if (!solo.waitForText("�������벻һ�£�����������")) {
			showErrLog(tag + ":register() :������ȷ�����벻һ��");
		}
		// δ��ѡ�û�Э��
		clear(("com.ksfc.newfarmer:id/confimPasword"));
		enter(("com.ksfc.newfarmer:id/confimPasword"), Config.pwd_cur);
		if (solo.isCheckBoxChecked(0)) {
			v("com.ksfc.newfarmer:id/check_box");
		}
		t("����ע��");
		if (!solo.waitForText("��ͬ����վʹ��Э��")) {
			showErrLog(tag + ":register() :δ��ѡ�û�Э��");
		}
		// �鿴�û�Э��
		v("com.ksfc.newfarmer:id/register_layoutxieyi");
		g();
		// ��֤������û�в��ҵ���֤��
		v("com.ksfc.newfarmer:id/check_box");
		t("����ע��");
		boolean a = solo.waitForText("��֤���������");
		boolean b = solo.waitForText("û�в��ҵ���֤��");
		if (!(a | b)) {
			showErrLog(tag + ":register() :��֤������û�в��ҵ���֤��");
		}

		// ��ת��¼ҳ��
		t("��¼");
		solo.assertCurrentActivity(tag + ":register(): ��ת��¼ҳ��", "LoginActivity");
		g();
		t("��ҳ");
	}

	// ��¼����
	public void loginTest() {
		login();
		// ��¼ҳ��������ҳ�����ת
		t("�������룿");
		solo.assertCurrentActivity(tag + "testLogin():��¼ҳ��������ҳ�����ת",
				"RetrievePasswordActivity");
		g();
		t("����ע��");
		solo.assertCurrentActivity(tag + "testLogin():��¼ҳ��������ҳ�����ת",
				"RegisterActivity");
		g();
		g();
		t("��ҳ");
		// ��¼�������ϲ����Ƶ��˻�
		login_sure(Config.pNum_null);
		solo.assertCurrentActivity(tag + ":testLogin():��¼�������ϲ����Ƶ��˻�",
				"ImprovePersonActivity");
		// δ�����ֻ���
		login();
		clear(("com.ksfc.newfarmer:id/login_layout_phone"));
		t("ȷ�ϵ�¼");
		if (!solo.waitForText("�������ֻ���")) {
			showErrLog(tag + ":loginTest():δ�����ֻ���");
		}
		// ��ʽ������ֻ���
		enter(("com.ksfc.newfarmer:id/login_layout_phone"), Config.pNum_err);
		t("ȷ�ϵ�¼");
		if (!solo.waitForText("��������ȷ���ֻ���")) {
			showErrLog(tag + ":loginTest():��ʽ������ֻ���");
		}
		// ����δע����ֻ���
		clear(("com.ksfc.newfarmer:id/login_layout_phone"));
		enter(("com.ksfc.newfarmer:id/login_layout_phone"), Config.pNum_unReg);
		enter("com.ksfc.newfarmer:id/login_layoutpassword", Config.pwd_cur);
		t("ȷ�ϵ�¼");
		if (!solo.waitForText("���ֻ���δע�ᣬ����������")) {
			showErrLog(tag + ":loginTest():����δע����ֻ���");
		}

		// δ��������
		clear(("com.ksfc.newfarmer:id/login_layout_phone"));
		enter(("com.ksfc.newfarmer:id/login_layout_phone"), Config.pNum_reg);
		clear("com.ksfc.newfarmer:id/login_layoutpassword");
		t("ȷ�ϵ�¼");
		if (!solo.waitForText("����������")) {
			showErrLog(tag + ":loginTest():δ��������");
		}

		// �����������
		enter(("com.ksfc.newfarmer:id/login_layoutpassword"), Config.pwd_err);
		t("ȷ�ϵ�¼");
		if (!solo.waitForText("�����������������")) {
			showErrLog(tag + ":loginTest():�����������");
		}

		// ֻ��������
		clear("com.ksfc.newfarmer:id/login_layout_phone");
		t("ȷ�ϵ�¼");
		if (!solo.waitForText("�������ֻ���")) {
			showErrLog(tag + ":loginTest():ֻ��������");
		}

		// ��¼�����������Ƶ��˻�
		clear("com.ksfc.newfarmer:id/login_layout_phone");
		enter("com.ksfc.newfarmer:id/login_layout_phone", Config.pNum_reg);
		clear("com.ksfc.newfarmer:id/login_layoutpassword");
		enter(("com.ksfc.newfarmer:id/login_layoutpassword"), Config.pwd_cur);
		t("ȷ�ϵ�¼");
		solo.assertCurrentActivity(tag + ":testLogin():��¼�����������Ƶ��˻�",
				"MineActivity");
		t("��ҳ");
	}

	// ��������ҳ��
	public void forgetPassword() {
		// ������������ҳ��
		login();
		t("�������룿");
		// δ��д�ֻ���
		t("���");
		if (!solo.waitForText("�������ֻ���")) {
			showErrLog(tag + ": forgetPassword():δ��д�ֻ���");
		}
		// ��ʽ������ֻ���
		enter(("com.ksfc.newfarmer:id/backedit1"), Config.pNum_err);
		v("com.ksfc.newfarmer:id/backgetVerificationCode");
		if (!solo.waitForText("��������ȷ���ֻ���")) {
			showErrLog(tag + ": forgetPassword():��ʽ������ֻ���");
		}
		// δע����ֻ���
		clear("com.ksfc.newfarmer:id/backedit1");
		enter(("com.ksfc.newfarmer:id/backedit1"), Config.pNum_unReg);
		v("com.ksfc.newfarmer:id/backgetVerificationCode");
		if (!solo.waitForText("���ֻ���δע�ᣬ����������")) {
			showErrLog(tag + ": forgetPassword():δע����ֻ���");
		}

		// �����������������֤�룬����ͼƬ��֤��
		clear("com.ksfc.newfarmer:id/backedit1");
		enter(("com.ksfc.newfarmer:id/backedit1"), Config.pNum_reg);
		v("com.ksfc.newfarmer:id/backgetVerificationCode");
		if (!solo.searchText("��ȫ��֤", true)) {
			g();
			t("�������룿");
			enter(("com.ksfc.newfarmer:id/backedit1"), Config.pNum_reg);
			v("com.ksfc.newfarmer:id/backgetVerificationCode");
		}
		if (!solo.searchText("��ȫ��֤", true)) {
			showErrLog(tag + ": forgetPassword():�����������������֤�룬����ͼƬ��֤��");
		}
		// û����дͼ����֤��
		solo.clickOnButton("ȷ��");
		if (!solo.searchText("������ͼ����֤��", true)) {
			showErrLog(tag + ":forgetPassword() :û����дͼ����֤��");
		}
		// ͼ����֤�����
		enter("com.ksfc.newfarmer:id/sms_auth_code_et", "123");
		solo.clickOnButton("ȷ��");
		if (!solo.searchText("ͼ����֤�����", true)) {
			showErrLog(tag + ":forgetPassword() :ͼ����֤�����");
		}
		solo.clickOnButton("ȡ��");

		// δ��д��֤��
		t("���");
		if (!solo.waitForText("��������֤��")) {
			showErrLog(tag + ": forgetPassword():δ��д��֤��");
		}

		// δ��д������
		enter(("com.ksfc.newfarmer:id/backyanzhengma"), "1111");// ������Ǵ������֤��
		t("���");
		if (!solo.waitForText("����������")) {
			showErrLog(tag + ": forgetPassword():δ��д������");
		}

		// δ��дȷ������
		enter(("com.ksfc.newfarmer:id/backnewpassword"), Config.pwd_err);
		t("���");
		if (!solo.waitForText("������ȷ������")) {
			showErrLog(tag + ": forgetPassword():δ��дȷ������");
		}

		// ������ȷ�������ʽ����ȷС����λ
		enter(("com.ksfc.newfarmer:id/confimPasword"), Config.pwd_err);
		t("���");
		if (!solo.waitForText("���볤�Ȳ�С��6λ")) {
			showErrLog(tag + ": forgetPassword():������ȷ�������ʽ����ȷС����λ");
		}

		// ������ȷ�����벻һ��
		clear("com.ksfc.newfarmer:id/backnewpassword");
		enter(("com.ksfc.newfarmer:id/backnewpassword"), Config.pwd_cur);// �������Ϊ��ȷ������
		t("���");
		if (!solo.waitForText("�����������벻һ�£�����������")) {
			showErrLog(tag + ": forgetPassword(): ������ȷ�����벻һ��");
		}

		// ��֤�����
		clear("com.ksfc.newfarmer:id/confimPasword");
		enter(("com.ksfc.newfarmer:id/confimPasword"), Config.pwd_cur);
		t("���");
		boolean a = solo.waitForText("��֤���������");
		boolean b = solo.waitForText("��֤���ѹ��ڣ������»�ȡ");
		if (!(a|b)) {
			showErrLog(tag + ": forgetPassword():��֤�����");
		}
		g();
		g();// ���ص��ҵ�ҳ��
	}
}
