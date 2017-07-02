import java.util.List;

public class Person {
	
	private String name;
	private Address address;
	private int age;
	private List<String> skills;
	
	public String getname()
	{
		return name;
	}
	
	public void setname(String name)
	{
		this.name = name;
	}
	
	
	
	public int getage()
	{
		return age;
	}
	
	public void setage(int age)
	{
		this.age = age;
	}


	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	

}
