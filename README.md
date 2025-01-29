# LLama2Test

Reference:
https://github.com/mukel/llama2.java

I just splitted out a bit to better study it.


need tokenizer.bin in src/bin dir: 
you can take it from https://github.com/karpathy/llama2.c/raw/master/tokenizer.bin


download trainint set, example: 
https://huggingface.co/karpathy/tinyllamas/resolve/main/stories15M.bin

sue GGUF format?

Run example:

./run.sh ./src/bin/stories42M.bin -z ./src/bin/tokenizer.bin -i "Gianna was really hungry"

./run.sh ./src/bin/llama-2-7b-chat.ggmlv3.q4_K_M.bin -z ./src/bin/tokenizer.bin -i "Give me 5 things to do in NYC"


./run3.sh -i --model ./src/bin/Llama-3.2-3B-Instruct-Q4_0.gguf

./run3.sh -i --model ./src/bin/DeepSeek-R1-Distill-Llama-8B-Q4_K_M.gguf

./run3.sh -i --model ./src/bin/DeepSeek-R1-Distill-Llama-8B-Q8_0.gguf
./run3.sh -i --model ./src/bin/DeepSeek-R1-Distill-Llama-8B-F16.gguf

References
==========

https://github.com/ggerganov/ggml/blob/master/docs/gguf.md


