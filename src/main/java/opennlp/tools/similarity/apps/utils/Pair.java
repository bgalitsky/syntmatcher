package opennlp.tools.similarity.apps.utils;

/**
 * Generic pair class for holding two objects. Often used as return object.
 * 
 * @author Albert-Jan de Vries
 * 
 * @param <T1>
 * @param <T2>
 */
public class Pair<T1, T2>
{
	private T1 first;

	private T2 second;

	public Pair()
	{

	}

	public Pair(T1 first, T2 second)
	{
		this.first = first;
		this.second = second;
	}

	public T1 getFirst()
	{
		return first;
	}

	public void setFirst(T1 first)
	{
		this.first = first;
	}

	public T2 getSecond()
	{
		return second;
	}

	public void setSecond(T2 second)
	{
		this.second = second;
	}
}
