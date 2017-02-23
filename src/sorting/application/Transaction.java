package sorting.application;

import java.util.Comparator;

import edu.princeton.cs.algs4.Date;

public class Transaction {
	private final String who;
	private final Date when;
	private final double amount;
	
	public Transaction(String who, Date when, double amount) {
		this.who = who;
		this.when = when;
		this.amount = amount;
	}
	
	public static class WhenOrder implements Comparator<Transaction>{

		@Override
		public int compare(Transaction o1, Transaction o2) {
			return o1.when.compareTo(o2.when);
		}
		
	}
}
