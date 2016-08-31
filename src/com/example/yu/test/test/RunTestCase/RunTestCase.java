package com.example.yu.test.test.RunTestCase;

import com.example.yu.test.test.CaseClearing;
import com.example.yu.test.test.CaseFunction;
import com.example.yu.test.test.CaseHomePage;
import com.example.yu.test.test.CaseMyNewFarmer;

public class RunTestCase extends BaseCase{

	public void test_ren(){
		//CaseHomePage.caseInstance(solo).test_run();
		CaseFunction.caseInstance(solo).test_run();
		CaseMyNewFarmer.caseInstance(solo).test_run();
	}

}
