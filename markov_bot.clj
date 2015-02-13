;; gorilla-repl.fileformat = 1

;; **
;;; # Clojure Markov Bot Tutorial
;;; 
;;; ## Introduction
;;; The goal of this tutorial is to create a program that generates human-looking sentences, by reproducing patterns that exist in a sample text.
;;; 
;;; To achieve this, we'll break the sample text into n-grams. An _n-gram_ is a succession of _n_ words in the text. n-grams capture common word sequences; if we generate text following existing n-grams, we'll get a "plausible" sequence of words, without having to understand how language works.
;;; 
;;; We'll guide you through writing a Markov bot generating text based on _bigrams_, sequences of two words. Then, we'll suggest directions for exploring further!
;; **

;; @@
;; Sample text: "What a Wonderful World"
;; http://en.wikipedia.org/wiki/What_a_Wonderful_world

(def sample = "
  I see trees of green, red roses, too,
  I see them bloom, for me and you
  And I think to myself
  What a wonderful world.
  
  I see skies of blue, and clouds of white,
  The bright blessed day, the dark sacred night
  And I think to myself
  What a wonderful world.
  
  The colors of the rainbow, so pretty in the sky,
  Are also on the faces of people going by.
  I see friends shaking hands, sayin', \"How do you do?\"
  They're really sayin', \"I love you.\"
  
  I hear babies cryin'. I watch them grow.
  They'll learn much more than I'll ever know
  And I think to myself
  What a wonderful world
  
  Yes, I think to myself
  What a wonderful world.")
;; @@

;; **
;;; ## Chapter 1: Breaking the input into bigrams
;;; Your goal here is to take the input text, and break it into a collection of bigrams--that is, consecutive words.
;;; 
;;; For instance, "the colors of the rainbow" produces four bigrams:
;;; * the,colors
;;; * colors,of
;;; * of,the
;;; * the,rainbow
;; **

;; @@
(def test-text (clojure.string/split "the colors of the rainbow" #" "))

(def numbers (range 1 11))

(def by-five (partition 2 1 numbers))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;user/by-five</span>","value":"#'user/by-five"}
;; <=

;; **
;;; First, write a function `bigramify` that breaks a text into an array of bigrams.
;; **

;; @@
(defn bigramify [text]
  ;; Your code goes here
  [])
;; @@

;; **
;;; ## Chapter 2: Finding next word candidates
;;; Now that you have isolated bigrams, given a starting word, you will need to find all the words that could follow it.
;;; 
;;; To do this, you need to extract all the bigrams where the first word matches and return all the next words in the selected bigrams, in an array.
;; **

;; @@
;; An array of pairs = arrays of integers
(def pairs [[1 2] [1 3] [4 2]])

(def ends-with-two (filter #(= second 2)))

(def second-elements (map #(second %) pairs))
;; @@

;; **
;;; Now, write a function `next-words` that returns all words following a given word.
;; **

;; @@
(defn next-words [bigrams]
  ;; Your code goes here!
  ["this" "is" "an" "example"])
;; @@

;; **
;;; ## Chapter 3: Generating a "sentence"
;;; Almost there! The only thing we need now is to start from an initial word, find a next word using the bigrams from the sample, append it to the sentence, and repeat until we find no next word.
;;; 
;;; There are many ways to do this, recursion being one option.
;; **

;; @@
;; string concatenation example

(def word1 "hello")

(def word2 "world")

(def concatenated (str word1 ", " word2))

;; recursion example

(defn repeat-n-times [times word]
  ;; create a recursive function
  (defn rec [counter sentence]
    (if (> counter times)
      sentence
      (let [updated (str sentence " " word)]
        (repeat-n-times (+ 1 counter) updated))))
  (repeat-n-times 1 ""))

(repeat-n-times 3 "Hello?")
;; @@

;; **
;;; Now, write a function `generate-words` that breaks sample text into bigrams and, starting from an input word, produces a sentence by appending words.
;; **

;; @@
(defn generate-words [sample-string]
  ;; TODO
  ;; 1. extract bigrams from sample
  ;; 2. recursively append words based on bigrams,
  ;;    starting from first-word
  "Not implemented yet!")
;; @@

;; **
;;; ## Next episode: Have fun!
;;; By now, you should have a function `generate-words` that produces "variations" based on the song "What a Wonderful World".
;;; 
;;; The next steps are entirely up to you!
;;; 
;;; Here are a couple of ideas you could explore:
;;; 
;;; 1. The song is fairly short, and it doesn't have many sentences or patterns. You will get more interesting and fun results by using longer samples, or by mixing samples of different origins.
;;; 
;;; 2. Bigrams are short patterns. You can get more "realistic-looking" results by using trigrams, or 4-, 5-, etc.-grams. For instance, with trigrams, you would look for sequences of three words, like "I/see/trees", "I/see/them", ... and generate forward:
;;; 
;;; 	* starting with "I/see/"
;;; 	* pick (for instance) "them"
;;; 	* continue with "see/them"
;;; 
;;; 3. Improve performance, by storing n-grams in a suitable data structure?
;;; 
;;; 4. Being smarter when parsing the sample. Splitting on white space is very crude, and it makes it difficult to find where a sentence starts or ends, for example. It also makes it difficult to find good points at which to stop generating words.
;;; 
;;; 5. Create a Markov buddy: write a bot that responds to user input, with a sentence that is "reasonable."
;; **
