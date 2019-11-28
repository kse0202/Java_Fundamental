package java_20191127;

/**
 이 클래스는 인터페이스를 테스트합니다. 
 */
import java.util.*;
import java.sql.*;

public class implementClassDemo {
	/**
	 * 이 메서드는 JVM이 호출해주는 메서드 입니다.
	 */
	public static void main(String[] args) {
		java.util.Date d = new java.util.Date();
		InterA a = new ImplementClass();
		a.mA();
		a.mB();
		a.mC();
	}

}
