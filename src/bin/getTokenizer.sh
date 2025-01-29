#!/bin/bash
if [ ! -f tokenizer.bin ]; then
  wget https://github.com/karpathy/llama2.c/raw/master/tokenizer.bin
fi