package kr.koreait.collectionTest;

public class Person implements Comparable<Person> {
	private String name;
	private int age;
		
	public Person() {}	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + "(" + age + ")";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	//compareTo() : 메소드는 자기 자신(this)의 멤버 변수 내용과 인수로 넘어온 객체(o)의 변수의 내용을 비교한다.
	public int compareTo(Person o) {
		//compareTo() 메소드는 문자열을 비교해서 자신의 멤버가 크면 1을 같으면 0을 자신의 멤버가 작으면 -1을
		//리턴하게 만든다
		//숫자는 자신의 멤버가 크면 양수를 같으면 0을 자신의 멤버가 작으면 음수를 리턴하게 만든다.
		
		//return this.name.compareTo(o.name); // name의 오름차순 정렬
		//return -this.name.compareTo(o.name); //  name의 내림차순 정렬
		//return this.age - o.age; // age의 오름차순 정렬
		//return o.age - this.age; // age의 내림차순 정렬
		
		//name의 내림차순 정렬, name이 같으면 age의 오름차순 정렬
		
		/*if(this.name.compareTo(o.name) == 0){
			return this.age - o.age;
		}
		else{
			return this.name.compareTo(o.name);
		}*/
		
		return this.name.compareTo(o.name) == 0 ? this.age - o.age : this.name.compareTo(o.name); 
	}		
}
