public class Codec {
    public HashMap<String, String> urlMap = new HashMap<>();
    String baseUrl = "https://tinyurl.com/";
    int counter = 0;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = String.valueOf(counter++);
        String shortUrl = baseUrl + key;
        urlMap.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urlMap.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));


// public class Codec {
//     public Map<String, String> map = new HashMap<>();
//     // Encodes a URL to a shortened URL.
//     public String encode(String longUrl) {
//         String key = "keeyy";
//         map.put(key, longUrl);
//         return key;
//     }

//     // Decodes a shortened URL to its original URL.
//     public String decode(String shortUrl) {
//         return map.get(shortUrl);
//     }
// }
