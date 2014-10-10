package JUnitTest;

import java.util.Currency;


public class Money {

	private long amount;
	private Currency currency;
	
	public Money(long amount, Currency currency){
		this.amount = amount;
		this.currency = currency;
	}
	
	public long getAmount(){
		return amount;
	}
	public Currency getCurrency(){
		return currency;
	}
	public String toString(){
		String sign = (amount < 0 ? "-" : "");
		Long absAmount = (amount < 0 ? -amount : amount);
		String code = currency.getCurrencyCode();
		int fractDigits = currency.getDefaultFractionDigits();
		int unit = tenToPower(fractDigits);
		if(fractDigits > 0){
			return sign + absAmount/unit + "." + fill(fractDigits, absAmount % unit) + code;
		}
		else return sign;
	}
	public String fill(int fractDigits, long l) {
		String lString = Long.toString(l);
		String str = "";
		
		for(int i = 0; i < fractDigits - lString.length(); i++){
			str += "0";
		}
		str = str + lString;
		return str;
	}

	public int tenToPower(int fractDigits) {
		fractDigits = (int) Math.pow(10, fractDigits);
		return fractDigits;
	}

	public int CompareTo(Money o){
		if(amount > o.getAmount()){
			return 1;
		}
		else if(amount < o.getAmount()){
			return -1;
		}
		else return 0;
	}
	@Override
	public boolean equals(Object o){
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Money other = (Money) o;
		if (amount != other.amount)
			return false;
		if (currency != other.currency)
			return false;
		
		return true;
	}
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (amount ^ (amount >>> 32));
		return result;
	}
	public Money plus(Money money){
		this.amount += money.amount;
		return this;
	}
	public Money minus(Money money){
		this.amount -= money.amount;
		return this;
	}
	public Money times(double factor){
		this.amount *= factor;
		return this;
		}
	public Money dividedBy(double divisor){
		if(divisor != 0){
			this.amount = (long) (this.amount/divisor);
		}
		return this;
	}
	public Money negate(){
		this.amount *= -1;
		return this;
	}
	

}
