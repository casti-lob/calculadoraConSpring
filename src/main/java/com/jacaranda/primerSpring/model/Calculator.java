package com.jacaranda.primerSpring.model;

import java.util.Objects;

public class Calculator {
	private double num1;
	private double num2;
	private String op;
	public Calculator() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Calculator(double num1, double num2, String op) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.op= op;
	}
	public double getNum1() {
		return num1;
	}
	public void setNum1(double num1) {
		this.num1 = num1;
	}
	public double getNum2() {
		return num2;
	}
	public void setNum2(double num2) {
		this.num2 = num2;
	}
	
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public double operation() {
		System.out.println(op);
		double result=0;
		switch (op) {
		case "+": {
			
			result=suma(this.num1, this.num2);
			break;
		}case "-":{
			result=resta(this.num1, this.num2);
			break;
		}case "*":{
			result=multiplicacion(this.num1, this.num2);
			break;
		}case "/":{
			result=division(this.num1, this.num2);
			break;
		}
		default:
			System.out.println("se ha producido un error");
		}
		
		return result;
	}
	
	public double suma(double num1, double num2) {
		return num1+num2;
	}
	public double resta(double num1, double num2) {
		return num1-num2;
	}
	public double multiplicacion(double num1, double num2) {
		return num1*num2;
	}
	public double division(double num1, double num2) {
		return num1/num2;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(num1, num2);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calculator other = (Calculator) obj;
		return Double.doubleToLongBits(num1) == Double.doubleToLongBits(other.num1)
				&& Double.doubleToLongBits(num2) == Double.doubleToLongBits(other.num2);
	}
	
	

}
