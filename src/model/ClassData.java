package model;

import java.util.LinkedList;
import java.util.List;

public class ClassData {
	private String name;
	private List<String> attributes = new LinkedList<String>();
	private List<String> methods = new LinkedList<String>();
	private ClassState state;
}
