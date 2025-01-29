package ch.arons.llama3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Utility tailored for Llama 3 instruct prompt format.
 */
class ChatFormat {

    final Tokenizer tokenizer;
    Integer beginOfText;
    Integer endHeader;
    Integer startHeader;
    Integer endOfTurn;
    Integer endOfText;
    Integer endOfMessage;
    Set<Integer> stopTokens;

    public ChatFormat(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
        Map<String, Integer> specialTokens = this.tokenizer.getSpecialTokens();
        if(specialTokens != null) {
            this.beginOfText = specialTokens.get("<|begin_of_text|>");
            this.startHeader = specialTokens.get("<|start_header_id|>");
            this.endHeader = specialTokens.get("<|end_header_id|>");
            this.endOfTurn = specialTokens.get("<|eot_id|>");
            this.endOfText = specialTokens.get("<|end_of_text|>");
            this.endOfMessage = specialTokens.getOrDefault("<|eom_id|>", -1); // only in 3.1
            this.stopTokens = Set.of(endOfText, endOfTurn);
//            if(beginOfText == null) {
//                beginOfText = Integer.valueOf(128000);
//            }
//            
//            if(startHeader == null) {
//                startHeader = Integer.valueOf(128006);
//            }
//            
//            if(endHeader == null) {
//                endHeader = Integer.valueOf(128007);
//            }
//            
//            if(endOfTurn == null) {
//                endOfTurn = Integer.valueOf(128009);
//            }
//            
//            if(endOfText == null) {
//                endOfText = Integer.valueOf(128001);
//            }
//            
//            if(endOfMessage == null) {
//                endOfMessage = Integer.valueOf(endOfMessage);
//            }
//
//            
//            
//            this.stopTokens = Set.of(endOfText == null ? 0 :endOfText, endOfTurn == null ?  0 : endOfTurn);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("beginOfText:").append(beginOfText).append("\n");
        sb.append("startHeader:").append(startHeader).append("\n");
        sb.append("endHeader:").append(endHeader).append("\n");
        sb.append("endOfTurn:").append(endOfTurn).append("\n");
        sb.append("endOfText:").append(endOfText).append("\n");
        sb.append("endOfMessage:").append(endOfMessage).append("\n");
        System.out.println(sb.toString());
        
    }

    public Tokenizer getTokenizer() {
        return tokenizer;
    }

    public Set<Integer> getStopTokens() {
        return stopTokens;
    }

    public List<Integer> encodeHeader(ChatFormat.Message message) {
        List<Integer> tokens = new ArrayList<>();
        tokens.add(startHeader);
        tokens.addAll(this.tokenizer.encodeAsList(message.role().name()));
        tokens.add(endHeader);
        tokens.addAll(this.tokenizer.encodeAsList("\n"));
        return tokens;
    }

    public List<Integer> encodeMessage(ChatFormat.Message message) {
        List<Integer> tokens = this.encodeHeader(message);
        tokens.addAll(this.tokenizer.encodeAsList(message.content().strip()));
        tokens.add(endOfTurn);
        return tokens;
    }

    public List<Integer> encodeDialogPrompt(boolean appendAssistantTurn, List<ChatFormat.Message> dialog) {
        List<Integer> tokens = new ArrayList<>();
        tokens.add(beginOfText);
        for (ChatFormat.Message message : dialog) {
            tokens.addAll(this.encodeMessage(message));
        }
        if (appendAssistantTurn) {
            // Add the start of an assistant message for the model to complete.
            tokens.addAll(this.encodeHeader(new ChatFormat.Message(ChatFormat.Role.ASSISTANT, "")));
        }
        return tokens;
    }

    public record Message(ChatFormat.Role role, String content) {
    }

    public record Role(String name) {
        public static ChatFormat.Role SYSTEM = new ChatFormat.Role("system");
        public static ChatFormat.Role USER = new ChatFormat.Role("user");
        public static ChatFormat.Role ASSISTANT = new ChatFormat.Role("assistant");

        @Override
        public String toString() {
            return name;
        }
    }
}


