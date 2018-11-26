package designpattern.behavioural;

public class ChainOfResponsibility {

	public static void main(String[] args) {
		// hierarchy of staff is created
		ClassTeacher classTeacher = new ClassTeacher(new VicePrincipal(new Principal(null)));
		// 3 complaint requests are created and sent to class teacher
		classTeacher.handleComplaint(new ComplaintRequest(3, "A101"));
		classTeacher.handleComplaint(new ComplaintRequest(7, "B202"));
		classTeacher.handleComplaint(new ComplaintRequest(10, "C303"));
	}

}

class ComplaintRequest {
	private int pastComplaintCount;
	private String studentRollNo;

	public ComplaintRequest(int pastComplaintCount, String studentRollNo) {
		super();
		this.pastComplaintCount = pastComplaintCount;
		this.studentRollNo = studentRollNo;
	}

	public int getPastComplaintCount() {
		return pastComplaintCount;
	}

	public void setPastComplaintCount(int pastComplaintCount) {
		this.pastComplaintCount = pastComplaintCount;
	}

	public String getStudentRollNo() {
		return studentRollNo;
	}

	public void setStudentRollNo(String studentRollNo) {
		this.studentRollNo = studentRollNo;
	}

}

abstract class Staff {
	protected Staff successor = null;

	public Staff(Staff successor) {
		super();
		this.successor = successor;
	}

	public abstract void handleComplaint(ComplaintRequest complaintRequest);
}

// ClassTeacher.java
class ClassTeacher extends Staff {
	public ClassTeacher(Staff successor) {
		super(successor);
	}

	@Override
	public void handleComplaint(ComplaintRequest complaintRequest) {
		if (complaintRequest.getPastComplaintCount() <= 4) {
			System.out.println("ClassTeacher handled the complaint for roll no:" + complaintRequest.getStudentRollNo());
		} else {
			successor.handleComplaint(complaintRequest);
		}
	}
}

// VicePrincipal.java
class VicePrincipal extends Staff {
	public VicePrincipal(Staff successor) {
		super(successor);
	}

	@Override
	public void handleComplaint(ComplaintRequest complaintRequest) {
		if (complaintRequest.getPastComplaintCount() <= 9) {
			System.out
					.println("VicePrincipal handled the complaint for roll no:" + complaintRequest.getStudentRollNo());
		} else {
			successor.handleComplaint(complaintRequest);
		}
	}
}

// Principal.java
class Principal extends Staff {
	public Principal(Staff successor) {
		super(successor);
	}

	@Override
	public void handleComplaint(ComplaintRequest complaintRequest) {
		System.out.println("Principal handled the complaint for roll no:" + complaintRequest.getStudentRollNo());
	}
}