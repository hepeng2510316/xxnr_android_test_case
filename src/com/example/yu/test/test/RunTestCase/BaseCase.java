package com.example.yu.test.test.RunTestCase;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import android.util.Log;
import android.view.View;

import com.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.TextView;

public class BaseCase extends ActivityInstrumentationTestCase2 {

	public Solo solo;

	public void instance(Solo solo1) {
		solo = solo1;
	}

	/**
	 * ע������������̬�����ַ��� ��һ����Ҫ���Եİ������͸ո���AndroidMainfest�����õİ���һ�� �ֻ��Զ���֮
	 * Robotium--�����ŵ���ͨ 39 �ڶ��Ǳ������������ �������ڳ����İ����������
	 */
	/**
	 * t(s);�����Ӧ�ַ�����Text v(s);���ID���ַ�����Ӧ��View b(s);�����Ӧ�ַ�����Button s();����1S
	 * jump();�ڶ���ҳ��û�ж���ʽ������ת����������ר��
	 * */
	public static final String TARGET_PACKAGE_ID = "com.ksfc.newfarmer";
	public static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.ksfc.newfarmer.activitys.SplashActivity";
	// ����һ��Class���͵ı���������ActivityInstrumentationTestCase2���������������
	public static Class launcherActivityClass;
	// ��̬����auncherActivityClassҲ���Ǳ����������
	static {
		try {
			launcherActivityClass = Class
					.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	// ���캯��������TARGET_PACKAGE_ID,launcherActivityClass����
	public BaseCase() {
		super(TARGET_PACKAGE_ID, launcherActivityClass);
	}

	@Before
	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
		instance(solo);
	}

	@After
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

	// �ý�������ָ��ʱ��
	public void s() {
		solo.sleep(Config.t);
	}

	// ���Text
	public void t(String s) {
		solo.clickOnText(s);
		s();
	}
	
	// ���Text
		public void t(String s,int i) {
			solo.clickOnText(s,i);
			s();
		}


	// ���View
	public void v(String s) {
		solo.clickOnView(solo.getView(s));
		s();
	}

	// ģ�ⷵ�ذ���
	public void g() {
		solo.goBack();
	}

	// ���������ڵ�����
	public void clear(String id) {
		solo.clearEditText((android.widget.EditText) solo.getView(id));
	}

	// �������ı�������������
	public void enter(String id, String text) {
		solo.enterText((android.widget.EditText) solo.getView(id), text);
	}

	// ��ȡ��Ӧid��TextView�ڵ�String
	public String getTextViewString(String id) {
		TextView view = null;
		view = (TextView) solo.getView(id);
		String s = view.getText().toString();
		return s;
	}

	// ��ȡ��Ӧid��TextView�ڵ���ʾ���ֲ�����ת��ΪString
	public String getTextHintString(String id) {
		TextView view = null;
		view = (TextView) solo.getView(id);
		String s = (String) view.getHint();
		return s;
	}

	// ��ȡ��Ӧid��EditText�ڵ�Text��ת��ΪString
	public String getEditTextString(String id) {
		EditText ev = (EditText) solo.getView(id);
		String s=ev.getText().toString();
		return s;
	}

	// ��ӡdeBugLog
	public void showLog(String msg) {
		Log.d("Robotium", msg);
	}

	// ��ӡ����LOG
	public void showErrLog(String msg) {
		Log.e("Robotium", msg);
	}

	// �����¼����
	public void login() {
		t("�ҵ�");
		if (!solo.searchText("������½", 1, false, true)) {
			v("com.ksfc.newfarmer:id/head_View_bg");
			t("�˳���¼");
			solo.clickOnButton("ȷ��");
			v("com.ksfc.newfarmer:id/head_View_bg");

		} else {
			v("com.ksfc.newfarmer:id/head_View_bg");
		}
	}

	// ȷ���˳���¼
	public void logout() {
		t("�ҵ�");
		if (!solo.searchText("������½", 1, false, true)) {
			v("com.ksfc.newfarmer:id/head_View_bg");
			t("�˳���¼");
			solo.clickOnButton("ȷ��");
		}
		t("��ҳ");
	}

	// ȷ�ϵ�¼(����������������Ҫ��¼���˻�)
	public void login_sure(String pNum) {
		t("�ҵ�");
		if (solo.searchText("������½", 1, false, true)) {
			v("com.ksfc.newfarmer:id/head_View_bg");
			clear("com.ksfc.newfarmer:id/login_layout_phone");
			enter(("com.ksfc.newfarmer:id/login_layout_phone"), pNum);
			enter(("com.ksfc.newfarmer:id/login_layoutpassword"),
					Config.pwd_cur);
			t("ȷ�ϵ�¼");
			if (solo.searchText("����", 1, false, true)) {
				v("com.ksfc.newfarmer:id/choice_cancel");
			}
			t("��ҳ");
		} else {
			v("com.ksfc.newfarmer:id/head_View_bg");
			t("�˳���¼");
			solo.clickOnButton("ȷ��");
			v("com.ksfc.newfarmer:id/head_View_bg");
			clear("com.ksfc.newfarmer:id/login_layout_phone");
			enter(("com.ksfc.newfarmer:id/login_layout_phone"), pNum);//
			enter(("com.ksfc.newfarmer:id/login_layoutpassword"),
					Config.pwd_cur);
			t("ȷ�ϵ�¼");
			if (solo.searchText("����", 1, false, true)) {
				v("com.ksfc.newfarmer:id/choice_cancel");
			}
			t("��ҳ");
		}

	}

	// ����ָ����View
	public void dragView(View view, float dragPercentFrom_X,
			float dragPercentFrom_Y, float dragPercentTo_X,
			float dragPercentTo_Y) {
		// �洢view�ĸ߶ȺͿ��
		int[] xyLocation = new int[2];
		// �洢view��xy���꣬���½�����ֵ
		view.getLocationOnScreen(xyLocation);
		// ��ȡview�Ŀ�� final
		int viewWidth = view.getWidth();
		// ��ȡview�ĸ߶� final
		int viewHeight = view.getHeight();
		// ����view�����Ͻǵ�x����
		final float viewLeftTop_x = xyLocation[0];
		// ����view�����Ͻǵ�y����
		final float viewLeftTop_y = xyLocation[1];

		float FromX = viewLeftTop_x + viewWidth * dragPercentFrom_X;
		float FromY = viewLeftTop_y + viewHeight * dragPercentFrom_Y;
		float ToX = viewLeftTop_x + viewWidth * dragPercentTo_X;
		float ToY = viewLeftTop_y + viewHeight * dragPercentTo_Y;
		solo.drag(FromX, ToX, FromY, ToY, 3);
	}

	/**
	 * �������һ���޶���Χ�ڵ�����
	 */
	public int getRandomInt(int begin, int end) {
		int a = begin + (int) (Math.random() * end);
		return a;
	}
	
	/**
	 * �������һ��ָ��λ��������
	 */
	public String getRandomIntString(int length){
		String s="";
		for(int a=0;a<length;a++){
			s=s+""+(0+(int)(Math.random()*9));
		}
		return s;
	}
	/**
	 * ��������޶����ȵ��ַ���
	 */
	public String getRandomString(int length) { 
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789";   
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }  
	    return sb.toString();
	}
}
