package iCaster.Tuple;
 

public class TupleUtil
{
	public static <Count, Data> DataTuple<Count, Data> DataTuple(Count count, Data data)
	{
		return new DataTuple<Count, Data>(count, data);
	}
}
