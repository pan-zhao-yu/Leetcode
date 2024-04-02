class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> normalized = new HashSet<>(); // used to save simplified email address, cost O(n) sapce.
        for (String email : emails) {
            String[] parts = email.split("@"); // split into local and domain parts.
            String[] local = parts[0].split("\\+"); // split local by '+'.
            normalized.add(local[0].replace(".", "") + "@" + parts[1]); // remove all '.', and concatenate '@' and domain.        
        }
        return normalized.size();
    }
}


// class Solution {
//     public int numUniqueEmails(String[] emails) {
//         HashSet<String> uniqueEmails = new HashSet<>();
//         for(String email : emails){
//             String formatEmail = getFormatEmail(email);
//             uniqueEmails.add(formatEmail);
//         }
//         return uniqueEmails.size();
//     }
//     private String getFormatEmail(String email){
//         String[] separet = email.split("@");
//         String local = separet[0];
//         String domain = separet[1];
//         local = local.replace(".", "");
//         String[] localPlus = local.split("\\+");
//         local = localPlus[0];
//         return local + "@" + domain;
//     }
// }