import redis.clients.jedis.Jedis;

public class test1
{
    public static void main(String[] args) throws Exception
    {
        Jedis jedis=new Jedis("127.0.0.1");
        jedis.set("name","names");
        System.out.println(jedis.get("name"));
    }
}
