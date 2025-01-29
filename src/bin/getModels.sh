#!/bin/bash

if [ ! -f stories15M.bin ]; then
  wget https://huggingface.co/karpathy/tinyllamas/resolve/main/stories15M.bin
fi

if [ ! -f stories42M.bin ]; then
  wget https://huggingface.co/karpathy/tinyllamas/resolve/main/stories42M.bin
fi

if [ ! -f llama-2-7b-chat.ggmlv3.q4_K_M.bin ]; then
  wget https://huggingface.co/TheBloke/Llama-2-7B-Chat-GGML/resolve/main/llama-2-7b-chat.ggmlv3.q4_K_M.bin
fi

if [ ! -f Llama-3.2-3B-Instruct-Q4_0.gguf ]; then
  wget https://huggingface.co/mukel/Llama-3.2-3B-Instruct-GGUF/resolve/main/Llama-3.2-3B-Instruct-Q4_0.gguf
fi

if [ ! -f DeepSeek-R1-Distill-Llama-8B-Q4_K_M.gguf ]; then
  wget https://huggingface.co/unsloth/DeepSeek-R1-Distill-Llama-8B-GGUF/blob/main/DeepSeek-R1-Distill-Llama-8B-Q4_K_M.gguf
fi
