/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.twiml.voice;

import com.twilio.twiml.TwiML;

/**
 * TwiML wrapper for {@code <p>}
 */
public class SsmlP extends TwiML {
    private final String words;

    /**
     * For XML Serialization/Deserialization
     */
    private SsmlP() {
        this(new Builder());
    }

    /**
     * Create a new {@code <p>} element
     */
    private SsmlP(Builder b) {
        super("p", b);
        this.words = b.words;
    }

    /**
     * The body of the TwiML element
     *
     * @return Element body as a string if present else null
     */
    protected String getElementBody() {
        return this.getWords() == null ? null : this.getWords();
    }

    /**
     * Words to speak
     *
     * @return Words to speak
     */
    public String getWords() {
        return words;
    }

    /**
     * Create a new {@code <p>} element
     */
    public static class Builder extends TwiML.Builder<Builder> {
        private String words;

        /**
         * Create a {@code <p>} with words
         */
        public Builder(String words) {
            this.words = words;
        }

        /**
         * Create a {@code <p>} with child elements
         */
        public Builder() {
        }

        /**
         * Add a child {@code <break>} element
         */
        public Builder break_(SsmlBreak ssmlBreak) {
            this.children.add(ssmlBreak);
            return this;
        }

        /**
         * Add a child {@code <emphasis>} element
         */
        public Builder emphasis(SsmlEmphasis ssmlEmphasis) {
            this.children.add(ssmlEmphasis);
            return this;
        }

        /**
         * Add a child {@code <lang>} element
         */
        public Builder lang(SsmlLang ssmlLang) {
            this.children.add(ssmlLang);
            return this;
        }

        /**
         * Add a child {@code <phoneme>} element
         */
        public Builder phoneme(SsmlPhoneme ssmlPhoneme) {
            this.children.add(ssmlPhoneme);
            return this;
        }

        /**
         * Add a child {@code <prosody>} element
         */
        public Builder prosody(SsmlProsody ssmlProsody) {
            this.children.add(ssmlProsody);
            return this;
        }

        /**
         * Add a child {@code <s>} element
         */
        public Builder s(SsmlS ssmlS) {
            this.children.add(ssmlS);
            return this;
        }

        /**
         * Add a child {@code <say-as>} element
         */
        public Builder sayAs(SsmlSayAs ssmlSayAs) {
            this.children.add(ssmlSayAs);
            return this;
        }

        /**
         * Add a child {@code <sub>} element
         */
        public Builder sub(SsmlSub ssmlSub) {
            this.children.add(ssmlSub);
            return this;
        }

        /**
         * Add a child {@code <w>} element
         */
        public Builder w(SsmlW ssmlW) {
            this.children.add(ssmlW);
            return this;
        }

        /**
         * Create and return resulting {@code <p>} element
         */
        public SsmlP build() {
            return new SsmlP(this);
        }
    }
}