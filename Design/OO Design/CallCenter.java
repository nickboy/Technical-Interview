public class CallHandler {
	private static CallHandler instance;

	private final int LEVELS = 3;

	private final int NUM_RESPONDENTS = 10;
	private final int NUM_MANAGERS = 4;
	private final int NUM_DIRECTORS = 2;

	ArrayList<Employee>[] employeeLevels;

	Queue<Call>[] callQueues;

	public CallHandler() {}

	// Singleton Pattern
	public static CallHandler getInstance() {
		if (instance == null) {
			instance = new CallHandler();
		}

		return instance;
	}

	public Employee getHandlerForCall (Call call) {}

	public void dispatchCall(Caller caller) {
		Call call = new Call(caller);
		dispatchCall(call);
	}

	public void dispatchCall(Call call) {
		Employee emp = getHandlerForCall(call);
		if (emp != null ) {
			emp.receiveCall(call);
			call.setHandler(emp);
		} else {
			call.reply("Please wait for free employee to reply");
			callQueues[call.getRank().getValue()].add(call);
		}
	}

	public boolean assignCall(Employee emp) {}
}

public class Call {
	private Rank rank;
	private Caller caller;

	private Employee handler;

	public Call(Caller c) {
		rank = Rank.Responder;
		caller = c;
	}

	public void setHandler(Employee e) {
		handler = e;
	}

	public void reply(String message){}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank r) {
		rank = r;
	}

	public Rank incrementRank() {}

	public void disconnect() {}
}