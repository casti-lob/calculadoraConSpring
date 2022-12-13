package com.jacaranda.primerSpring.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jacaranda.primerSpring.model.Student;

@Service
public class StudentService {
	
	private List<Student> lista;

	public StudentService() {
		lista = new ArrayList<Student>();
		lista.add(new Student("jose","castillejo",26));
		lista.add(new Student("Manolo","Perez",36));
		lista.add(new Student("Desconocido","Misterio",16));
	}
	public List<Student> getStudents(){
		return lista;
	}
	public boolean addStudent(Student e) {
		return lista.add(e);
	}
	public boolean removeStudent(Student o) {
		return lista.remove(o);
	}
	public  Student getStudent(String nombre, String apellido) {
		Boolean encontrado= false;
		Student resultado=null;
		Iterator<Student> iterator = this.lista.iterator();
		while(iterator.hasNext()&&!encontrado) {
			resultado=iterator.next();
			if(resultado.getName().equals(nombre)&& resultado.getSurname().equals(apellido)) {
				
				encontrado=true;
			}
		}
		if(encontrado==true)
			return resultado;
		else
			return null;
	}
	
	public Boolean updateStudent(String nombre, String apellido, int edad) {
		Boolean encontrado= false;
		Student resultado=null;
		Iterator<Student> iterator = this.lista.iterator();
		while(iterator.hasNext()&&!encontrado) {
			resultado=iterator.next();
			if(resultado.getName().equals(nombre)&& resultado.getSurname().equals(apellido)) {
				resultado.setAge(edad);
				encontrado=true;
			}
		}
		
		return encontrado;
	}
}
