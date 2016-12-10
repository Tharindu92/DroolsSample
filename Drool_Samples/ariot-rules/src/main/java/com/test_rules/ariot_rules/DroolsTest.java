package com.test_rules.ariot_rules;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;
/**
 * Hello world!
 *
 */
public class DroolsTest 
{
	public static void main(String[] args) throws DroolsParserException,
	IOException {
	DroolsTest droolsTest = new DroolsTest();
	droolsTest.executeDrools();
	}
	
	public void executeDrools() throws DroolsParserException, IOException {
	
	PackageBuilder packageBuilder = new PackageBuilder();
	
	String ruleFile = "/com/rules/Rules.drl";
	InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);
	Reader reader = new InputStreamReader(resourceAsStream);
	packageBuilder.addPackageFromDrl(reader);
	org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
	RuleBase ruleBase = RuleBaseFactory.newRuleBase();
	ruleBase.addPackage(rulesPackage);
	
	WorkingMemory workingMemory = ruleBase.newStatefulSession();
	
	Product product = new Product();
	product.setType("humidity");
	product.setReading(80);
	
	workingMemory.insert(product);
	workingMemory.fireAllRules();
	
	System.out.println("The anomely for the product " + product.getType()
			+ " is " + product.isAnomely());
}
}
