/*
 * Copyright 2016 The International Internet Preservation Consortium.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.netpreserve.commons.uri;

import org.netpreserve.commons.uri.parser.Parser;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Configuration for a UriBuilder.
 * <p>
 * This class is immutable and thread safe. All methods setting a value returns a fresh copy.
 */
public final class UriBuilderConfig {

    private int maxUrlLength = Integer.MAX_VALUE;

    private Parser parser = Configurations.STRICT_PARSER;

    private ReferenceResolver referenceResolver = Configurations.REFERENCE_RESOLVER;

    private List<PreParseNormalizer> preParseNormalizers = Collections.emptyList();

    private List<InParseNormalizer> inParseNormalizers = Collections.emptyList();

    private List<PostParseNormalizer> postParseNormalizers = Collections.emptyList();

    private Charset charset = StandardCharsets.UTF_8;

    private boolean requireAbsoluteUri = false;

    private boolean strictReferenceResolution = true;

    private boolean caseNormalization = true;

    private boolean percentEncodingNormalization = true;

    private boolean pathSegmentNormalization = true;

    private boolean schemeBasedNormalization = false;

    private boolean encodeIllegalCharacters = false;

    private boolean punycodeUnknownScheme = false;

    private UriFormat defaultFormat = Configurations.DEFAULT_FORMAT;

    public int getMaxUrlLength() {
        return maxUrlLength;
    }

    public Parser getParser() {
        return parser;
    }

    public ReferenceResolver getReferenceResolver() {
        return referenceResolver;
    }

    public Charset getCharset() {
        return charset;
    }

    public boolean isRequireAbsoluteUri() {
        return requireAbsoluteUri;
    }

    public boolean isStrictReferenceResolution() {
        return strictReferenceResolution;
    }

    /**
     * Returns true if the URI's case should be normalized.
     * <p>
     * Converts scheme and hostname to lower case. Percent encoded characters are converted to upper case.
     * <p>
     * @return true if the URI's case should be normalized
     */
    public boolean isCaseNormalization() {
        return caseNormalization;
    }

    /**
     * Returns true if HEX values should be normalized.
     * <p>
     * If this parameter is true, all HEX values will be uppercased. For percent encoded characters, unnecessary encoded
     * characters will be decoded. Illegal characters will be encoded.
     * <p>
     * @return true if HEX values should be normalized
     */
    public boolean isPercentEncodingNormalization() {
        return percentEncodingNormalization;
    }

    public boolean isPathSegmentNormalization() {
        return pathSegmentNormalization;
    }

    public boolean isSchemeBasedNormalization() {
        return schemeBasedNormalization;
    }

    public boolean isEncodeIllegalCharacters() {
        return encodeIllegalCharacters;
    }

    public boolean isPunycodeUnknownScheme() {
        return punycodeUnknownScheme;
    }

    public List<PreParseNormalizer> getPreParseNormalizers() {
        return preParseNormalizers;
    }

    public List<InParseNormalizer> getInParseNormalizers() {
        return inParseNormalizers;
    }

    public List<PostParseNormalizer> getPostParseNormalizers() {
        return postParseNormalizers;
    }

    public UriFormat getDefaultFormat() {
        return defaultFormat;
    }

    public UriBuilderConfig maxUrlLength(final int value) {
        UriBuilderConfig copy = new UriBuilderConfig(this);
        copy.maxUrlLength = value;
        return copy;
    }

    public UriBuilderConfig parser(final Parser value) {
        UriBuilderConfig copy = new UriBuilderConfig(this);
        copy.parser = value;
        return copy;
    }

    public UriBuilderConfig referenceResolver(final ReferenceResolver value) {
        UriBuilderConfig copy = new UriBuilderConfig(this);
        copy.referenceResolver = value;
        return copy;
    }

    public UriBuilderConfig charset(final Charset value) {
        UriBuilderConfig copy = new UriBuilderConfig(this);
        copy.charset = value;
        return copy;
    }

    public UriBuilderConfig defaultFormat(final UriFormat value) {
        UriBuilderConfig copy = new UriBuilderConfig(this);
        copy.defaultFormat = value;
        return copy;
    }

    public UriBuilderConfig requireAbsoluteUri(final boolean value) {
        UriBuilderConfig copy = new UriBuilderConfig(this);
        copy.requireAbsoluteUri = value;
        return copy;
    }

    public UriBuilderConfig strictReferenceResolution(final boolean value) {
        UriBuilderConfig copy = new UriBuilderConfig(this);
        copy.strictReferenceResolution = value;
        return copy;
    }

    /**
     * Set if the URI's case should be normalized.
     * <p>
     * Converts scheme and hostname to lower case. Percent encoded characters are converted to upper case.
     * <p>
     * @param value set to true for case normalization
     * @return this UriBuilderConfig for command chaining
     */
    public UriBuilderConfig caseNormalization(final boolean value) {
        UriBuilderConfig copy = new UriBuilderConfig(this);
        copy.caseNormalization = value;
        return copy;
    }

    /**
     * Set if HEX values should be normalized.
     * <p>
     * If this parameter is set to true, all HEX values will be uppercased. For percent encoded characters, unnecessary
     * encoded characters will be decoded. Illegal characters will be encoded.
     * <p>
     * @param value set to true for HEX normalization
     * @return this UriBuilderConfig for command chaining
     */
    public UriBuilderConfig percentEncodingNormalization(final boolean value) {
        UriBuilderConfig copy = new UriBuilderConfig(this);
        copy.percentEncodingNormalization = value;
        return copy;
    }

    public UriBuilderConfig pathSegmentNormalization(final boolean value) {
        UriBuilderConfig copy = new UriBuilderConfig(this);
        copy.pathSegmentNormalization = value;
        return copy;
    }

    public UriBuilderConfig schemeBasedNormalization(final boolean value) {
        UriBuilderConfig copy = new UriBuilderConfig(this);
        copy.schemeBasedNormalization = value;
        return copy;
    }

    public UriBuilderConfig encodeIllegalCharacters(final boolean value) {
        UriBuilderConfig copy = new UriBuilderConfig(this);
        copy.encodeIllegalCharacters = value;
        return copy;
    }

    public UriBuilderConfig punycodeUnknownScheme(final boolean value) {
        UriBuilderConfig copy = new UriBuilderConfig(this);
        copy.punycodeUnknownScheme = value;
        return copy;
    }

    public UriBuilderConfig addNormalizer(Normalizer normalizer) {
        UriBuilderConfig copy = new UriBuilderConfig(this);
        if (normalizer instanceof PreParseNormalizer) {
            List<PreParseNormalizer> listCopy = new ArrayList<>(copy.preParseNormalizers);
            listCopy.add((PreParseNormalizer) normalizer);
            copy.preParseNormalizers = Collections.unmodifiableList(listCopy);
        }
        if (normalizer instanceof InParseNormalizer) {
            List<InParseNormalizer> listCopy = new ArrayList<>(copy.inParseNormalizers);
            listCopy.add((InParseNormalizer) normalizer);
            copy.inParseNormalizers = Collections.unmodifiableList(listCopy);
        }
        if (normalizer instanceof PostParseNormalizer) {
            List<PostParseNormalizer> listCopy = new ArrayList<>(copy.postParseNormalizers);
            listCopy.add((PostParseNormalizer) normalizer);
            copy.postParseNormalizers = Collections.unmodifiableList(listCopy);
        }
        return copy;
    }

    public UriBuilderConfig removeNormalizersOfType(Class<? extends Normalizer> normalizer) {
        UriBuilderConfig copy = new UriBuilderConfig(this);
        if (PreParseNormalizer.class.isAssignableFrom(normalizer)) {
            List<PreParseNormalizer> listCopy = new ArrayList<>(copy.preParseNormalizers);
            listCopy.removeIf((PreParseNormalizer t) -> normalizer.isInstance(t));
            copy.preParseNormalizers = Collections.unmodifiableList(listCopy);
        }
        if (InParseNormalizer.class.isAssignableFrom(normalizer)) {
            List<InParseNormalizer> listCopy = new ArrayList<>(copy.inParseNormalizers);
            listCopy.removeIf((InParseNormalizer t) -> normalizer.isInstance(t));
            copy.inParseNormalizers = Collections.unmodifiableList(listCopy);
        }
        if (PostParseNormalizer.class.isAssignableFrom(normalizer)) {
            List<PostParseNormalizer> listCopy = new ArrayList<>(copy.postParseNormalizers);
            listCopy.removeIf((PostParseNormalizer t) -> normalizer.isInstance(t));
            copy.postParseNormalizers = Collections.unmodifiableList(listCopy);
        }
        return copy;
    }

    /**
     * Construct a new UriBuilderConfig with all parameters set to default values.
     */
    public UriBuilderConfig() {
    }

    /**
     * Constructs a new UriBuilderConfig by copying all fields from another UriBuilderConfig.
     * <p>
     * This constructor is private to ensure immutability.
     * <p>
     * @param src the UriBuilderConfig to copy from
     */
    private UriBuilderConfig(UriBuilderConfig src) {
        this.maxUrlLength = src.getMaxUrlLength();
        this.parser = src.getParser();
        this.referenceResolver = src.getReferenceResolver();
        this.charset = src.getCharset();
        this.requireAbsoluteUri = src.isRequireAbsoluteUri();
        this.strictReferenceResolution = src.isStrictReferenceResolution();
        this.caseNormalization = src.isCaseNormalization();
        this.percentEncodingNormalization = src.isPercentEncodingNormalization();
        this.pathSegmentNormalization = src.isPathSegmentNormalization();
        this.schemeBasedNormalization = src.isSchemeBasedNormalization();
        this.encodeIllegalCharacters = src.isEncodeIllegalCharacters();
        this.punycodeUnknownScheme = src.isPunycodeUnknownScheme();
        this.preParseNormalizers = src.preParseNormalizers;
        this.inParseNormalizers = src.inParseNormalizers;
        this.postParseNormalizers = src.postParseNormalizers;
        this.defaultFormat = src.getDefaultFormat();
    }

}
