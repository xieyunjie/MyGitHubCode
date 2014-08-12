package iCaster.Tuple;

public class DataTuple<Count, Data>
{
	public final Count count;
	public final Data data;

	public DataTuple(Count c, Data d)
	{
		count = c;
		data = d; 
	}

	public String toString()
	{
		return data.hashCode() + "#" + count.toString();
	}

}
