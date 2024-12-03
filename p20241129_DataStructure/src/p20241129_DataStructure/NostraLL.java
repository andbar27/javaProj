package p20241129_DataStructure;

public class NostraLL<T> {
	
	private T value;
	private NostraLL<T> next;
	
	private NostraLL<T> first;
	
	
	protected NostraLL(T value, NostraLL<T> next) {
		super();
		this.value = value;
		this.next = next;
		this.first = null;
	}

	void AddFirst(T info) {
		NostraLL<T> o = new NostraLL<T>(info, this);
		
		if(this.first == null)
			this.first = o;
		else {
			o.next = this.first;
			this.first = o;
		}
	}
	
	void AddLast(T info) {
		NostraLL<T> o = new NostraLL<T>(info, null);
		
		if(this.first == null) {
			this.first = o;
			o.first = o;
			return;
		}	
		
		NostraLL<T> last = this.next;
		if(last == null) {
			this.next = o;
			o.first = this;
		}else {
			while(last.next != null) {
				last = last.next;
			}
			last.next = o;
		}
	}
	
//	void AddLast(T info) {
//		NostraLL<T> l = new NostraLL<T>(info, null);
//		l.value = info;
//		l.next = null;
//		if (first == null) {
//			first = l;
//			l.first = l;
//			return;
//		} 
//	
//		if (next == null) {
//			next = l;
//		} else {
//			while (next.next != null) {
//				next = next.next;
//			}
//			next.next = l;
//		}
//	
//	}

}
