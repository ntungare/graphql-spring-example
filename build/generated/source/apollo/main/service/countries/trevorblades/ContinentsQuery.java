// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package countries.trevorblades;

import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.OperationName;
import com.apollographql.apollo.api.Query;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.api.ResponseField;
import com.apollographql.apollo.api.ScalarTypeAdapters;
import com.apollographql.apollo.api.internal.Mutator;
import com.apollographql.apollo.api.internal.OperationRequestBodyComposer;
import com.apollographql.apollo.api.internal.QueryDocumentMinifier;
import com.apollographql.apollo.api.internal.ResponseFieldMapper;
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller;
import com.apollographql.apollo.api.internal.ResponseReader;
import com.apollographql.apollo.api.internal.ResponseWriter;
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser;
import com.apollographql.apollo.api.internal.Utils;
import countries.trevorblades.type.CustomType;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ContinentsQuery implements Query<ContinentsQuery.Data, ContinentsQuery.Data, Operation.Variables> {
  public static final String OPERATION_ID = "7e9e056e54dce527e98005411f811d34672d4a29011e72eb123f5828a7b72983";

  public static final String QUERY_DOCUMENT = QueryDocumentMinifier.minify(
    "query ContinentsQuery {\n"
        + "  continents {\n"
        + "    __typename\n"
        + "    code\n"
        + "    name\n"
        + "    countries {\n"
        + "      __typename\n"
        + "      code\n"
        + "      name\n"
        + "      native\n"
        + "      phone\n"
        + "      capital\n"
        + "      currency\n"
        + "      languages {\n"
        + "        __typename\n"
        + "        code\n"
        + "        name\n"
        + "        native\n"
        + "        rtl\n"
        + "      }\n"
        + "      emoji\n"
        + "      emojiU\n"
        + "      states {\n"
        + "        __typename\n"
        + "        code\n"
        + "        name\n"
        + "      }\n"
        + "    }\n"
        + "  }\n"
        + "}"
  );

  public static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "ContinentsQuery";
    }
  };

  private final Operation.Variables variables;

  public ContinentsQuery() {
    this.variables = Operation.EMPTY_VARIABLES;
  }

  @Override
  public String operationId() {
    return OPERATION_ID;
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public ContinentsQuery.Data wrapData(ContinentsQuery.Data data) {
    return data;
  }

  @Override
  public Operation.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<ContinentsQuery.Data> responseFieldMapper() {
    return new Data.Mapper();
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public OperationName name() {
    return OPERATION_NAME;
  }

  @Override
  @NotNull
  public Response<ContinentsQuery.Data> parse(@NotNull final BufferedSource source,
      @NotNull final ScalarTypeAdapters scalarTypeAdapters) throws IOException {
    return SimpleOperationResponseParser.parse(source, this, scalarTypeAdapters);
  }

  @Override
  @NotNull
  public Response<ContinentsQuery.Data> parse(@NotNull final ByteString byteString,
      @NotNull final ScalarTypeAdapters scalarTypeAdapters) throws IOException {
    return parse(new Buffer().write(byteString), scalarTypeAdapters);
  }

  @Override
  @NotNull
  public Response<ContinentsQuery.Data> parse(@NotNull final BufferedSource source) throws
      IOException {
    return parse(source, ScalarTypeAdapters.DEFAULT);
  }

  @Override
  @NotNull
  public Response<ContinentsQuery.Data> parse(@NotNull final ByteString byteString) throws
      IOException {
    return parse(byteString, ScalarTypeAdapters.DEFAULT);
  }

  @Override
  @NotNull
  public ByteString composeRequestBody(@NotNull final ScalarTypeAdapters scalarTypeAdapters) {
    return OperationRequestBodyComposer.compose(this, false, true, scalarTypeAdapters);
  }

  @NotNull
  @Override
  public ByteString composeRequestBody() {
    return OperationRequestBodyComposer.compose(this, false, true, ScalarTypeAdapters.DEFAULT);
  }

  @Override
  @NotNull
  public ByteString composeRequestBody(final boolean autoPersistQueries,
      final boolean withQueryDocument, @NotNull final ScalarTypeAdapters scalarTypeAdapters) {
    return OperationRequestBodyComposer.compose(this, autoPersistQueries, withQueryDocument, scalarTypeAdapters);
  }

  public static final class Builder {
    Builder() {
    }

    public ContinentsQuery build() {
      return new ContinentsQuery();
    }
  }

  /**
   * Data from the response after executing this GraphQL operation
   */
  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forList("continents", "continents", null, false, Collections.<ResponseField.Condition>emptyList())
    };

    final @NotNull List<Continent> continents;

    private transient volatile String $toString;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    public Data(@NotNull List<Continent> continents) {
      this.continents = Utils.checkNotNull(continents, "continents == null");
    }

    public @NotNull List<Continent> getContinents() {
      return this.continents;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeList($responseFields[0], continents, new ResponseWriter.ListWriter() {
            @Override
            public void write(List items, ResponseWriter.ListItemWriter listItemWriter) {
              for (Object item : items) {
                listItemWriter.writeObject(((Continent) item).marshaller());
              }
            }
          });
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "continents=" + continents
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return this.continents.equals(that.continents);
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= continents.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.continents = continents;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final Continent.Mapper continentFieldMapper = new Continent.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final List<Continent> continents = reader.readList($responseFields[0], new ResponseReader.ListReader<Continent>() {
          @Override
          public Continent read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<Continent>() {
              @Override
              public Continent read(ResponseReader reader) {
                return continentFieldMapper.map(reader);
              }
            });
          }
        });
        return new Data(continents);
      }
    }

    public static final class Builder {
      private @NotNull List<Continent> continents;

      Builder() {
      }

      public Builder continents(@NotNull List<Continent> continents) {
        this.continents = continents;
        return this;
      }

      public Builder continents(@NotNull Mutator<List<Continent.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<Continent.Builder> builders = new ArrayList<>();
        if (this.continents != null) {
          for (Continent item : this.continents) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<Continent> continents = new ArrayList<>();
        for (Continent.Builder item : builders) {
          continents.add(item != null ? item.build() : null);
        }
        this.continents = continents;
        return this;
      }

      public Data build() {
        Utils.checkNotNull(continents, "continents == null");
        return new Data(continents);
      }
    }
  }

  public static class Continent {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("code", "code", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("countries", "countries", null, false, Collections.<ResponseField.Condition>emptyList())
    };

    final @NotNull String __typename;

    final @NotNull String code;

    final @NotNull String name;

    final @NotNull List<Country> countries;

    private transient volatile String $toString;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    public Continent(@NotNull String __typename, @NotNull String code, @NotNull String name,
        @NotNull List<Country> countries) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.code = Utils.checkNotNull(code, "code == null");
      this.name = Utils.checkNotNull(name, "name == null");
      this.countries = Utils.checkNotNull(countries, "countries == null");
    }

    public @NotNull String get__typename() {
      return this.__typename;
    }

    public @NotNull String getCode() {
      return this.code;
    }

    public @NotNull String getName() {
      return this.name;
    }

    public @NotNull List<Country> getCountries() {
      return this.countries;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], code);
          writer.writeString($responseFields[2], name);
          writer.writeList($responseFields[3], countries, new ResponseWriter.ListWriter() {
            @Override
            public void write(List items, ResponseWriter.ListItemWriter listItemWriter) {
              for (Object item : items) {
                listItemWriter.writeObject(((Country) item).marshaller());
              }
            }
          });
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Continent{"
          + "__typename=" + __typename + ", "
          + "code=" + code + ", "
          + "name=" + name + ", "
          + "countries=" + countries
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Continent) {
        Continent that = (Continent) o;
        return this.__typename.equals(that.__typename)
         && this.code.equals(that.code)
         && this.name.equals(that.name)
         && this.countries.equals(that.countries);
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= __typename.hashCode();
        h *= 1000003;
        h ^= code.hashCode();
        h *= 1000003;
        h ^= name.hashCode();
        h *= 1000003;
        h ^= countries.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.code = code;
      builder.name = name;
      builder.countries = countries;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Continent> {
      final Country.Mapper countryFieldMapper = new Country.Mapper();

      @Override
      public Continent map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String code = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String name = reader.readString($responseFields[2]);
        final List<Country> countries = reader.readList($responseFields[3], new ResponseReader.ListReader<Country>() {
          @Override
          public Country read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<Country>() {
              @Override
              public Country read(ResponseReader reader) {
                return countryFieldMapper.map(reader);
              }
            });
          }
        });
        return new Continent(__typename, code, name, countries);
      }
    }

    public static final class Builder {
      private @NotNull String __typename;

      private @NotNull String code;

      private @NotNull String name;

      private @NotNull List<Country> countries;

      Builder() {
      }

      public Builder __typename(@NotNull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder code(@NotNull String code) {
        this.code = code;
        return this;
      }

      public Builder name(@NotNull String name) {
        this.name = name;
        return this;
      }

      public Builder countries(@NotNull List<Country> countries) {
        this.countries = countries;
        return this;
      }

      public Builder countries(@NotNull Mutator<List<Country.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<Country.Builder> builders = new ArrayList<>();
        if (this.countries != null) {
          for (Country item : this.countries) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<Country> countries = new ArrayList<>();
        for (Country.Builder item : builders) {
          countries.add(item != null ? item.build() : null);
        }
        this.countries = countries;
        return this;
      }

      public Continent build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(code, "code == null");
        Utils.checkNotNull(name, "name == null");
        Utils.checkNotNull(countries, "countries == null");
        return new Continent(__typename, code, name, countries);
      }
    }
  }

  public static class Country {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("code", "code", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("native", "native", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("phone", "phone", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("capital", "capital", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("currency", "currency", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("languages", "languages", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("emoji", "emoji", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("emojiU", "emojiU", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("states", "states", null, false, Collections.<ResponseField.Condition>emptyList())
    };

    final @NotNull String __typename;

    final @NotNull String code;

    final @NotNull String name;

    final @NotNull String native_;

    final @NotNull String phone;

    final @Nullable String capital;

    final @Nullable String currency;

    final @NotNull List<Language> languages;

    final @NotNull String emoji;

    final @NotNull String emojiU;

    final @NotNull List<State> states;

    private transient volatile String $toString;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    public Country(@NotNull String __typename, @NotNull String code, @NotNull String name,
        @NotNull String native_, @NotNull String phone, @Nullable String capital,
        @Nullable String currency, @NotNull List<Language> languages, @NotNull String emoji,
        @NotNull String emojiU, @NotNull List<State> states) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.code = Utils.checkNotNull(code, "code == null");
      this.name = Utils.checkNotNull(name, "name == null");
      this.native_ = Utils.checkNotNull(native_, "native_ == null");
      this.phone = Utils.checkNotNull(phone, "phone == null");
      this.capital = capital;
      this.currency = currency;
      this.languages = Utils.checkNotNull(languages, "languages == null");
      this.emoji = Utils.checkNotNull(emoji, "emoji == null");
      this.emojiU = Utils.checkNotNull(emojiU, "emojiU == null");
      this.states = Utils.checkNotNull(states, "states == null");
    }

    public @NotNull String get__typename() {
      return this.__typename;
    }

    public @NotNull String getCode() {
      return this.code;
    }

    public @NotNull String getName() {
      return this.name;
    }

    public @NotNull String getNative_() {
      return this.native_;
    }

    public @NotNull String getPhone() {
      return this.phone;
    }

    public @Nullable String getCapital() {
      return this.capital;
    }

    public @Nullable String getCurrency() {
      return this.currency;
    }

    public @NotNull List<Language> getLanguages() {
      return this.languages;
    }

    public @NotNull String getEmoji() {
      return this.emoji;
    }

    public @NotNull String getEmojiU() {
      return this.emojiU;
    }

    public @NotNull List<State> getStates() {
      return this.states;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], code);
          writer.writeString($responseFields[2], name);
          writer.writeString($responseFields[3], native_);
          writer.writeString($responseFields[4], phone);
          writer.writeString($responseFields[5], capital);
          writer.writeString($responseFields[6], currency);
          writer.writeList($responseFields[7], languages, new ResponseWriter.ListWriter() {
            @Override
            public void write(List items, ResponseWriter.ListItemWriter listItemWriter) {
              for (Object item : items) {
                listItemWriter.writeObject(((Language) item).marshaller());
              }
            }
          });
          writer.writeString($responseFields[8], emoji);
          writer.writeString($responseFields[9], emojiU);
          writer.writeList($responseFields[10], states, new ResponseWriter.ListWriter() {
            @Override
            public void write(List items, ResponseWriter.ListItemWriter listItemWriter) {
              for (Object item : items) {
                listItemWriter.writeObject(((State) item).marshaller());
              }
            }
          });
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Country{"
          + "__typename=" + __typename + ", "
          + "code=" + code + ", "
          + "name=" + name + ", "
          + "native_=" + native_ + ", "
          + "phone=" + phone + ", "
          + "capital=" + capital + ", "
          + "currency=" + currency + ", "
          + "languages=" + languages + ", "
          + "emoji=" + emoji + ", "
          + "emojiU=" + emojiU + ", "
          + "states=" + states
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Country) {
        Country that = (Country) o;
        return this.__typename.equals(that.__typename)
         && this.code.equals(that.code)
         && this.name.equals(that.name)
         && this.native_.equals(that.native_)
         && this.phone.equals(that.phone)
         && ((this.capital == null) ? (that.capital == null) : this.capital.equals(that.capital))
         && ((this.currency == null) ? (that.currency == null) : this.currency.equals(that.currency))
         && this.languages.equals(that.languages)
         && this.emoji.equals(that.emoji)
         && this.emojiU.equals(that.emojiU)
         && this.states.equals(that.states);
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= __typename.hashCode();
        h *= 1000003;
        h ^= code.hashCode();
        h *= 1000003;
        h ^= name.hashCode();
        h *= 1000003;
        h ^= native_.hashCode();
        h *= 1000003;
        h ^= phone.hashCode();
        h *= 1000003;
        h ^= (capital == null) ? 0 : capital.hashCode();
        h *= 1000003;
        h ^= (currency == null) ? 0 : currency.hashCode();
        h *= 1000003;
        h ^= languages.hashCode();
        h *= 1000003;
        h ^= emoji.hashCode();
        h *= 1000003;
        h ^= emojiU.hashCode();
        h *= 1000003;
        h ^= states.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.code = code;
      builder.name = name;
      builder.native_ = native_;
      builder.phone = phone;
      builder.capital = capital;
      builder.currency = currency;
      builder.languages = languages;
      builder.emoji = emoji;
      builder.emojiU = emojiU;
      builder.states = states;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Country> {
      final Language.Mapper languageFieldMapper = new Language.Mapper();

      final State.Mapper stateFieldMapper = new State.Mapper();

      @Override
      public Country map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String code = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String name = reader.readString($responseFields[2]);
        final String native_ = reader.readString($responseFields[3]);
        final String phone = reader.readString($responseFields[4]);
        final String capital = reader.readString($responseFields[5]);
        final String currency = reader.readString($responseFields[6]);
        final List<Language> languages = reader.readList($responseFields[7], new ResponseReader.ListReader<Language>() {
          @Override
          public Language read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<Language>() {
              @Override
              public Language read(ResponseReader reader) {
                return languageFieldMapper.map(reader);
              }
            });
          }
        });
        final String emoji = reader.readString($responseFields[8]);
        final String emojiU = reader.readString($responseFields[9]);
        final List<State> states = reader.readList($responseFields[10], new ResponseReader.ListReader<State>() {
          @Override
          public State read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<State>() {
              @Override
              public State read(ResponseReader reader) {
                return stateFieldMapper.map(reader);
              }
            });
          }
        });
        return new Country(__typename, code, name, native_, phone, capital, currency, languages, emoji, emojiU, states);
      }
    }

    public static final class Builder {
      private @NotNull String __typename;

      private @NotNull String code;

      private @NotNull String name;

      private @NotNull String native_;

      private @NotNull String phone;

      private @Nullable String capital;

      private @Nullable String currency;

      private @NotNull List<Language> languages;

      private @NotNull String emoji;

      private @NotNull String emojiU;

      private @NotNull List<State> states;

      Builder() {
      }

      public Builder __typename(@NotNull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder code(@NotNull String code) {
        this.code = code;
        return this;
      }

      public Builder name(@NotNull String name) {
        this.name = name;
        return this;
      }

      public Builder native_(@NotNull String native_) {
        this.native_ = native_;
        return this;
      }

      public Builder phone(@NotNull String phone) {
        this.phone = phone;
        return this;
      }

      public Builder capital(@Nullable String capital) {
        this.capital = capital;
        return this;
      }

      public Builder currency(@Nullable String currency) {
        this.currency = currency;
        return this;
      }

      public Builder languages(@NotNull List<Language> languages) {
        this.languages = languages;
        return this;
      }

      public Builder emoji(@NotNull String emoji) {
        this.emoji = emoji;
        return this;
      }

      public Builder emojiU(@NotNull String emojiU) {
        this.emojiU = emojiU;
        return this;
      }

      public Builder states(@NotNull List<State> states) {
        this.states = states;
        return this;
      }

      public Builder languages(@NotNull Mutator<List<Language.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<Language.Builder> builders = new ArrayList<>();
        if (this.languages != null) {
          for (Language item : this.languages) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<Language> languages = new ArrayList<>();
        for (Language.Builder item : builders) {
          languages.add(item != null ? item.build() : null);
        }
        this.languages = languages;
        return this;
      }

      public Builder states(@NotNull Mutator<List<State.Builder>> mutator) {
        Utils.checkNotNull(mutator, "mutator == null");
        List<State.Builder> builders = new ArrayList<>();
        if (this.states != null) {
          for (State item : this.states) {
            builders.add(item != null ? item.toBuilder() : null);
          }
        }
        mutator.accept(builders);
        List<State> states = new ArrayList<>();
        for (State.Builder item : builders) {
          states.add(item != null ? item.build() : null);
        }
        this.states = states;
        return this;
      }

      public Country build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(code, "code == null");
        Utils.checkNotNull(name, "name == null");
        Utils.checkNotNull(native_, "native_ == null");
        Utils.checkNotNull(phone, "phone == null");
        Utils.checkNotNull(languages, "languages == null");
        Utils.checkNotNull(emoji, "emoji == null");
        Utils.checkNotNull(emojiU, "emojiU == null");
        Utils.checkNotNull(states, "states == null");
        return new Country(__typename, code, name, native_, phone, capital, currency, languages, emoji, emojiU, states);
      }
    }
  }

  public static class Language {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("code", "code", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("native", "native", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forBoolean("rtl", "rtl", null, false, Collections.<ResponseField.Condition>emptyList())
    };

    final @NotNull String __typename;

    final @NotNull String code;

    final @Nullable String name;

    final @Nullable String native_;

    final boolean rtl;

    private transient volatile String $toString;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    public Language(@NotNull String __typename, @NotNull String code, @Nullable String name,
        @Nullable String native_, boolean rtl) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.code = Utils.checkNotNull(code, "code == null");
      this.name = name;
      this.native_ = native_;
      this.rtl = rtl;
    }

    public @NotNull String get__typename() {
      return this.__typename;
    }

    public @NotNull String getCode() {
      return this.code;
    }

    public @Nullable String getName() {
      return this.name;
    }

    public @Nullable String getNative_() {
      return this.native_;
    }

    public boolean isRtl() {
      return this.rtl;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], code);
          writer.writeString($responseFields[2], name);
          writer.writeString($responseFields[3], native_);
          writer.writeBoolean($responseFields[4], rtl);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Language{"
          + "__typename=" + __typename + ", "
          + "code=" + code + ", "
          + "name=" + name + ", "
          + "native_=" + native_ + ", "
          + "rtl=" + rtl
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Language) {
        Language that = (Language) o;
        return this.__typename.equals(that.__typename)
         && this.code.equals(that.code)
         && ((this.name == null) ? (that.name == null) : this.name.equals(that.name))
         && ((this.native_ == null) ? (that.native_ == null) : this.native_.equals(that.native_))
         && this.rtl == that.rtl;
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= __typename.hashCode();
        h *= 1000003;
        h ^= code.hashCode();
        h *= 1000003;
        h ^= (name == null) ? 0 : name.hashCode();
        h *= 1000003;
        h ^= (native_ == null) ? 0 : native_.hashCode();
        h *= 1000003;
        h ^= Boolean.valueOf(rtl).hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.code = code;
      builder.name = name;
      builder.native_ = native_;
      builder.rtl = rtl;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<Language> {
      @Override
      public Language map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String code = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String name = reader.readString($responseFields[2]);
        final String native_ = reader.readString($responseFields[3]);
        final boolean rtl = reader.readBoolean($responseFields[4]);
        return new Language(__typename, code, name, native_, rtl);
      }
    }

    public static final class Builder {
      private @NotNull String __typename;

      private @NotNull String code;

      private @Nullable String name;

      private @Nullable String native_;

      private boolean rtl;

      Builder() {
      }

      public Builder __typename(@NotNull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder code(@NotNull String code) {
        this.code = code;
        return this;
      }

      public Builder name(@Nullable String name) {
        this.name = name;
        return this;
      }

      public Builder native_(@Nullable String native_) {
        this.native_ = native_;
        return this;
      }

      public Builder rtl(boolean rtl) {
        this.rtl = rtl;
        return this;
      }

      public Language build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(code, "code == null");
        return new Language(__typename, code, name, native_, rtl);
      }
    }
  }

  public static class State {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("code", "code", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, false, Collections.<ResponseField.Condition>emptyList())
    };

    final @NotNull String __typename;

    final @Nullable String code;

    final @NotNull String name;

    private transient volatile String $toString;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    public State(@NotNull String __typename, @Nullable String code, @NotNull String name) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.code = code;
      this.name = Utils.checkNotNull(name, "name == null");
    }

    public @NotNull String get__typename() {
      return this.__typename;
    }

    public @Nullable String getCode() {
      return this.code;
    }

    public @NotNull String getName() {
      return this.name;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], code);
          writer.writeString($responseFields[2], name);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "State{"
          + "__typename=" + __typename + ", "
          + "code=" + code + ", "
          + "name=" + name
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof State) {
        State that = (State) o;
        return this.__typename.equals(that.__typename)
         && ((this.code == null) ? (that.code == null) : this.code.equals(that.code))
         && this.name.equals(that.name);
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= __typename.hashCode();
        h *= 1000003;
        h ^= (code == null) ? 0 : code.hashCode();
        h *= 1000003;
        h ^= name.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public Builder toBuilder() {
      Builder builder = new Builder();
      builder.__typename = __typename;
      builder.code = code;
      builder.name = name;
      return builder;
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Mapper implements ResponseFieldMapper<State> {
      @Override
      public State map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String code = reader.readString($responseFields[1]);
        final String name = reader.readString($responseFields[2]);
        return new State(__typename, code, name);
      }
    }

    public static final class Builder {
      private @NotNull String __typename;

      private @Nullable String code;

      private @NotNull String name;

      Builder() {
      }

      public Builder __typename(@NotNull String __typename) {
        this.__typename = __typename;
        return this;
      }

      public Builder code(@Nullable String code) {
        this.code = code;
        return this;
      }

      public Builder name(@NotNull String name) {
        this.name = name;
        return this;
      }

      public State build() {
        Utils.checkNotNull(__typename, "__typename == null");
        Utils.checkNotNull(name, "name == null");
        return new State(__typename, code, name);
      }
    }
  }
}
