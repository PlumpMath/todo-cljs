(ns todomvc.magic
  (:require [clojure.string :refer [split-lines]]))

(declare todo-learn-clojure-core)

(defn- split-items "private" [items-string]
  (split-lines items-string)
  )

(defn expand "Maybe expand key into multiple items" [key]
  (let [items (todo-learn-clojure-core key)]
    (println (str "items=" items))
    (if (nil? items)
      (doall
       (println (str "key=" key))
       (list key))
      (mapcat split-lines items))
    )
  )

(comment (def todo-learn-clojure-namespaces "clojure" "core
async
logic
data
edn
inspector
instant
java
browse
io
javadoc
shell
main
pprint
reflect
repl
set
stacktrace
string
template
test
walk
xml
zip
clojure.core
"))


(defn todo-learn-clojure-core "VARS IN CLOJURE.CORE" [key]
  (get
   {
        "*^%" [ "*
Returns the product of nums. (*) returns 1. Does not auto-promote longs, will throw on overflow. See also: *'
*'
Returns the product of nums. (*) returns 1. Supports arbitrary precision. See also: *
*1
bound in a repl thread to the most recent value printed
*2
bound in a repl thread to the second most recent value printed
*3
bound in a repl thread to the third most recent value printed
*agent*
The agent currently running an action on this thread, else nil
*allow-unresolved-vars*
no doc
*assert*
no doc
*clojure-version*
The version info for Clojure core, as a map containing :major :minor :incremental and :qualifier keys. Feature releases may increment :minor and/or :major, bugfix releases will increment :incremental. Possible values of :qualifier include \"GA\", \"SNAPSHOT\", \"RC-x\" \"BETA-x\"
*command-line-args*
A sequence of the supplied command line arguments, or nil if none were supplied
*compile-files*
Set to true when compiling files, false otherwise.
*compile-path*
Specifies the directory where 'compile' will write out .class files. This directory must be in the classpath for 'compile' to work. Defaults to \"classes\"
*compiler-options*
A map of keys to options. Note, when binding dynamically make sure to merge with previous value. Supported options: :elide-meta - a collection of metadata keys to elide during compilation. :disable-locals-clearing - set to true to disable clearing, useful for using a debugger Alpha, subject to change.
*data-readers*
Map from reader tag symbols to data reader Vars. When Clojure starts, it searches for files named 'data_readers.clj' at the root of the classpath. Each such file must contain a literal map of symbols, like this: {foo/bar my.project.foo/bar foo/baz my.project/baz} The first symbol in each pair is a tag that will be recognized by the Clojure reader. The second symbol in the pair is the fully-qualified name of a Var which will be invoked by the reader to parse the form following the tag. For example, given the data_readers.clj file above, the Clojure reader would parse this form: #foo/bar [1 2 3] by invoking the Var #'my.project.foo/bar on the vector [1 2 3]. The data reader function is invoked on the form AFTER it has been read as a normal Clojure data structure by the reader. Reader tags without namespace qualifiers are reserved for Clojure. Default reader tags are defined in clojure.core/default-data-readers but may be overridden in data_readers.clj or by rebinding this Var.
*default-data-reader-fn*
When no data reader is found for a tag and *default-data-reader-fn* is non-nil, it will be called with two arguments, the tag and the value. If *default-data-reader-fn* is nil (the default), an exception will be thrown for the unknown tag.
*e
bound in a repl thread to the most recent exception caught by the repl
*err*
A java.io.Writer object representing standard error for print operations. Defaults to System/err, wrapped in a PrintWriter
*file*
The path of the file being evaluated, as a String. When there is no file, e.g. in the REPL, the value is not defined.
*flush-on-newline*
When set to true, output will be flushed whenever a newline is printed. Defaults to true.
*fn-loader*
no doc
*in*
A java.io.Reader object representing standard input for read operations. Defaults to System/in, wrapped in a LineNumberingPushbackReader
*math-context*
no doc
*ns*
A clojure.lang.Namespace object representing the current namespace.
*out*
A java.io.Writer object representing standard output for print operations. Defaults to System/out, wrapped in an OutputStreamWriter
*print-dup*
When set to logical true, objects will be printed in a way that preserves their type when read in later. Defaults to false.
*print-length*
*print-length* controls how many items of each collection the printer will print. If it is bound to logical false, there is no limit. Otherwise, it must be bound to an integer indicating the maximum number of items of each collection to print. If a collection contains more items, the printer will print items up to the limit followed by '...' to represent the remaining items. The root binding is nil indicating no limit.
*print-level*
*print-level* controls how many levels deep the printer will print nested objects. If it is bound to logical false, there is no limit. Otherwise, it must be bound to an integer indicating the maximum level to print. Each argument to print is at level 0; if an argument is a collection, its items are at level 1; and so on. If an object is a collection and is at a level greater than or equal to the value bound to *print-level*, the printer prints '#' to represent it. The root binding is nil indicating no limit.
*print-meta*
If set to logical true, when printing an object, its metadata will also be printed in a form that can be read back by the reader. Defaults to false.
*print-readably*
When set to logical false, strings and characters will be printed with non-alphanumeric characters converted to the appropriate escape sequences. Defaults to true
*read-eval*
Defaults to true (or value specified by system property, see below) ***This setting implies that the full power of the reader is in play, including syntax that can cause code to execute. It should never be used with untrusted sources. See also: clojure.edn/read.*** When set to logical false in the thread-local binding, the eval reader (#=) and record/type literal syntax are disabled in read/load. Example (will fail): (binding [*read-eval* false] (read-string \"#=(* 2 21)\")) The default binding can be controlled by the system property 'clojure.read.eval' System properties can be set on the command line like this: java -Dclojure.read.eval=false ... The system property can also be set to 'unknown' via -Dclojure.read.eval=unknown, in which case the default binding is :unknown and all reads will fail in contexts where *read-eval* has not been explicitly bound to either true or false. This setting can be a useful diagnostic tool to ensure that all of your reads occur in considered contexts. You can also accomplish this in a particular scope by binding *read-eval* to :unknown
*source-path*
no doc
*unchecked-math*
While bound to true, compilations of +, -, *, inc, dec and the coercions will be done without overflow checks. Default: false.
*use-context-classloader*
no doc
*verbose-defrecords*
no doc
*warn-on-reflection*
When set to true, the compiler will emit warnings when reflection is needed to resolve Java method calls or field accesses. Defaults to false.
+
Returns the sum of nums. (+) returns 0. Does not auto-promote longs, will throw on overflow. See also: +'
+'
Returns the sum of nums. (+) returns 0. Supports arbitrary precision. See also: +
-
If no ys are supplied, returns the negation of x, else subtracts the ys from x and returns the result. Does not auto-promote longs, will throw on overflow. See also: -'
-'
If no ys are supplied, returns the negation of x, else subtracts the ys from x and returns the result. Supports arbitrary precision. See also: -
->
Threads the expr through the forms. Inserts x as the second item in the first form, making a list of it if it is not a list already. If there are more forms, inserts the first form as the second item in second form, etc.
->>
Threads the expr through the forms. Inserts x as the last item in the first form, making a list of it if it is not a list already. If there are more forms, inserts the first form as the last item in second form, etc.
->ArrayChunk
Positional factory function for class clojure.core.ArrayChunk.
->Vec
Positional factory function for class clojure.core.Vec.
->VecNode
Positional factory function for class clojure.core.VecNode.
->VecSeq
Positional factory function for class clojure.core.VecSeq.
-cache-protocol-fn
no doc
-reset-methods
no doc
.
The '.' special form is the basis for access to Java. It can be considered a member-access operator, and/or read as 'in the scope of'. See http://clojure.org/special_forms for more information.
..
form => fieldName-symbol or (instanceMethodName-symbol args*) Expands into a member access (.) of the first member on the first argument, followed by the next member on the result, etc. For instance: (.. System (getProperties) (get \"os.name\")) expands to: (. (. System (getProperties)) (get \"os.name\")) but is easier to write, read, and understand.
/
If no denominators are supplied, returns 1/numerator, else returns numerator divided by all of the denominators.
<
Returns non-nil if nums are in monotonically increasing order, otherwise false.
<=
Returns non-nil if nums are in monotonically non-decreasing order, otherwise false.
=
Equality. Returns true if x equals y, false if not. Same as Java x.equals(y) except it also works for nil, and compares numbers and collections in a type-independent manner. Clojure's immutable data structures define equals() (and thus =) as a value, not an identity, comparison.
==
Returns non-nil if nums all have the equivalent value (type-independent), otherwise false
>
Returns non-nil if nums are in monotonically decreasing order, otherwise false.
>=
Returns non-nil if nums are in monotonically non-increasing order, otherwise false."]
        "a" ["accessor
Returns a fn that, given an instance of a structmap with the basis, returns the value at the key. The key must be in the basis. The returned function should be (slightly) more efficient than using get, but such use of accessors should be limited to known performance-critical areas.
aclone
Returns a clone of the Java array. Works on arrays of known types.
add-classpath
DEPRECATED Adds the url (String or URL object) to the classpath per URLClassLoader.addURL
add-watch
Adds a watch function to an agent/atom/var/ref reference. The watch fn must be a fn of 4 args: a key, the reference, its old-state, its new-state. Whenever the reference's state might have been changed, any registered watches will have their functions called. The watch fn will be called synchronously, on the agent's thread if an agent, before any pending sends if agent or ref. Note that an atom's or ref's state may have changed again prior to the fn call, so use old/new-state rather than derefing the reference. Note also that watch fns may be called from multiple threads simultaneously. Var watchers are triggered only by root binding changes, not thread-local set!s. Keys must be unique per reference, and can be used to remove the watch with remove-watch, but are otherwise considered opaque by the watch mechanism.
agent
Creates and returns an agent with an initial value of state and zero or more options (in any order): :meta metadata-map :validator validate-fn :error-handler handler-fn :error-mode mode-keyword If metadata-map is supplied, it will become the metadata on the agent. validate-fn must be nil or a side-effect-free fn of one argument, which will be passed the intended new state on any state change. If the new state is unacceptable, the validate-fn should return false or throw an exception. handler-fn is called if an action throws an exception or if validate-fn rejects a new state -- see set-error-handler! for details. The mode-keyword may be either :continue (the default if an error-handler is given) or :fail (the default if no error-handler is given) -- see set-error-mode! for details.
agent-error
Returns the exception thrown during an asynchronous action of the agent if the agent is failed. Returns nil if the agent is not failed.
agent-errors
DEPRECATED: Use 'agent-error' instead. Returns a sequence of the exceptions thrown during asynchronous actions of the agent.
aget
Returns the value at the index/indices. Works on Java arrays of all types.
alength
Returns the length of the Java array. Works on arrays of all types.
alias
Add an alias in the current namespace to another namespace. Arguments are two symbols: the alias to be used, and the symbolic name of the target namespace. Use :as in the ns macro in preference to calling this directly.
all-ns
Returns a sequence of all namespaces.
alter
Must be called in a transaction. Sets the in-transaction-value of ref to: (apply fun in-transaction-value-of-ref args) and returns the in-transaction-value of ref.
alter-meta!
Atomically sets the metadata for a namespace/var/ref/agent/atom to be: (apply f its-current-meta args) f must be free of side-effects
alter-var-root
Atomically alters the root binding of var v by applying f to its current value plus any args
amap
Maps an expression across an array a, using an index named idx, and return value named ret, initialized to a clone of a, then setting each element of ret to the evaluation of expr, returning the new array ret.
ancestors
Returns the immediate and indirect parents of tag, either via a Java type inheritance relationship or a relationship established via derive. h must be a hierarchy obtained from make-hierarchy, if not supplied defaults to the global hierarchy
and
Evaluates exprs one at a time, from left to right. If a form returns logical false (nil or false), and returns that value and doesn't evaluate any of the other expressions, otherwise it returns the value of the last expr. (and) returns true.
apply
Applies fn f to the argument list formed by prepending intervening arguments to args.
areduce
Reduces an expression across an array a, using an index named idx, and return value named ret, initialized to init, setting ret to the evaluation of expr at each step, returning ret.
array-map
Constructs an array-map. If any keys are equal, they are handled as if by repeated uses of assoc.
as->
Binds name to expr, evaluates the first form in the lexical context of that binding, then binds name to that result, repeating for each successive form, returning the result of the last form.
aset
Sets the value at the index/indices. Works on Java arrays of reference types. Returns val.
aset-boolean
Sets the value at the index/indices. Works on arrays of boolean. Returns val.
aset-byte
Sets the value at the index/indices. Works on arrays of byte. Returns val.
aset-char
Sets the value at the index/indices. Works on arrays of char. Returns val.
aset-double
Sets the value at the index/indices. Works on arrays of double. Returns val.
aset-float
Sets the value at the index/indices. Works on arrays of float. Returns val.
aset-int
Sets the value at the index/indices. Works on arrays of int. Returns val.
aset-long
Sets the value at the index/indices. Works on arrays of long. Returns val.
aset-short
Sets the value at the index/indices. Works on arrays of short. Returns val.
assert
Evaluates expr and throws an exception if it does not evaluate to logical true.
assoc
assoc[iate]. When applied to a map, returns a new map of the same (hashed/sorted) type, that contains the mapping of key(s) to val(s). When applied to a vector, returns a new vector that contains val at index. Note - index must be <= (count vector).
assoc!
When applied to a transient map, adds mapping of key(s) to val(s). When applied to a transient vector, sets the val at index. Note - index must be <= (count vector). Returns coll.
assoc-in
Associates a value in a nested associative structure, where ks is a sequence of keys and v is the new value and returns a new nested structure. If any levels do not exist, hash-maps will be created.
associative?
Returns true if coll implements Associative
atom
Creates and returns an Atom with an initial value of x and zero or more options (in any order): :meta metadata-map :validator validate-fn If metadata-map is supplied, it will become the metadata on the atom. validate-fn must be nil or a side-effect-free fn of one argument, which will be passed the intended new state on any state change. If the new state is unacceptable, the validate-fn should return false or throw an exception.
await
Blocks the current thread (indefinitely!) until all actions dispatched thus far, from this thread or agent, to the agent(s) have occurred. Will block on failed agents. Will never return if a failed agent is restarted with :clear-actions true.
await-for
Blocks the current thread until all actions dispatched thus far (from this thread or agent) to the agents have occurred, or the timeout (in milliseconds) has elapsed. Returns logical false if returning due to timeout, logical true otherwise.
await1
no doc"]
        "b" ["bases
Returns the immediate superclass and direct interfaces of c, if any
bean
Takes a Java object and returns a read-only implementation of the map abstraction based upon its JavaBean properties.
bigdec
Coerce to BigDecimal
bigint
Coerce to BigInt
biginteger
Coerce to BigInteger
binding
binding => var-symbol init-expr Creates new bindings for the (already-existing) vars, with the supplied initial values, executes the exprs in an implicit do, then re-establishes the bindings that existed before. The new bindings are made in parallel (unlike let); all init-exprs are evaluated before the vars are bound to their new values.
bit-and
Bitwise and
bit-and-not
Bitwise and with complement
bit-clear
Clear bit at index n
bit-flip
Flip bit at index n
bit-not
Bitwise complement
bit-or
Bitwise or
bit-set
Set bit at index n
bit-shift-left
Bitwise shift left
bit-shift-right
Bitwise shift right
bit-test
Test bit at index n
bit-xor
Bitwise exclusive or
boolean
Coerce to boolean
boolean-array
Creates an array of booleans
booleans
Casts to boolean[]
bound-fn
Returns a function defined by the given fntail, which will install the same bindings in effect as in the thread at the time bound-fn was called. This may be used to define a helper function which runs on a different thread, but needs the same bindings in place.
bound-fn*
Returns a function, which will install the same bindings in effect as in the thread at the time bound-fn* was called and then call f with any given arguments. This may be used to define a helper function which runs on a different thread, but needs the same bindings in place.
bound?
Returns true if all of the vars provided as arguments have any bound value, root or thread-local. Implies that deref'ing the provided vars will succeed. Returns true if no vars are provided.
butlast
Return a seq of all but the last item in coll, in linear time
byte
Coerce to byte
byte-array
Creates an array of bytes
bytes
Casts to bytes[]"]
        "c" ["case
Takes an expression, and a set of clauses. Each clause can take the form of either: test-constant result-expr (test-constant1 ... test-constantN) result-expr The test-constants are not evaluated. They must be compile-time literals, and need not be quoted. If the expression is equal to a test-constant, the corresponding result-expr is returned. A single default expression can follow the clauses, and its value will be returned if no clause matches. If no default expression is provided and no clause matches, an IllegalArgumentException is thrown. Unlike cond and condp, case does a constant-time dispatch, the clauses are not considered sequentially. All manner of constant expressions are acceptable in case, including numbers, strings, symbols, keywords, and (Clojure) composites thereof. Note that since lists are used to group multiple constants that map to the same expression, a vector can be used to match a list if needed. The test-constants need not be all of the same type.
cast
Throws a ClassCastException if x is not a c, else returns x.
catch
The exprs are evaluated and, if no exceptions occur, the value of the last is returned. If an exception occurs and catch clauses are provided, each is examined in turn and the first for which the thrown exception is an instance of the named class is considered a matching catch clause. If there is a matching catch clause, its exprs are evaluated in a context in which name is bound to the thrown exception, and the value of the last is the return value of the function. If there is no matching catch clause, the exception propagates out of the function. Before returning, normally or abnormally, any finally exprs will be evaluated for their side effects. See http://clojure.org/special_forms for more information.
char
Coerce to char
char-array
Creates an array of chars
char-escape-string
Returns escape string for char or nil if none
char-name-string
Returns name string for char or nil if none
char?
Return true if x is a Character
chars
Casts to chars[]
chunk
no doc
chunk-append
no doc
chunk-buffer
no doc
chunk-cons
no doc
chunk-first
no doc
chunk-next
no doc
chunk-rest
no doc
chunked-seq?
no doc
class
Returns the Class of x
class?
Returns true if x is an instance of Class
clear-agent-errors
DEPRECATED: Use 'restart-agent' instead. Clears any exceptions thrown during asynchronous actions of the agent, allowing subsequent actions to occur.
clojure-version
Returns clojure version as a printable string.
coll?
Returns true if x implements IPersistentCollection
comment
Ignores body, yields nil
commute
Must be called in a transaction. Sets the in-transaction-value of ref to: (apply fun in-transaction-value-of-ref args) and returns the in-transaction-value of ref. At the commit point of the transaction, sets the value of ref to be: (apply fun most-recently-committed-value-of-ref args) Thus fun should be commutative, or, failing that, you must accept last-one-in-wins behavior. commute allows for more concurrency than ref-set.
comp
Takes a set of functions and returns a fn that is the composition of those fns. The returned fn takes a variable number of args, applies the rightmost of fns to the args, the next fn (right-to-left) to the result, etc.
comparator
Returns an implementation of java.util.Comparator based upon pred.
compare
Comparator. Returns a negative number, zero, or a positive number when x is logically 'less than', 'equal to', or 'greater than' y. Same as Java x.compareTo(y) except it also works for nil, and compares numbers and collections in a type-independent manner. x must implement Comparable
compare-and-set!
Atomically sets the value of atom to newval if and only if the current value of the atom is identical to oldval. Returns true if set happened, else false
compile
Compiles the namespace named by the symbol lib into a set of classfiles. The source for the lib must be in a proper classpath-relative directory. The output files will go into the directory specified by *compile-path*, and that directory too must be in the classpath.
complement
Takes a fn f and returns a fn that takes the same arguments as f, has the same effects, if any, and returns the opposite truth value.
concat
Returns a lazy seq representing the concatenation of the elements in the supplied colls.
cond
Takes a set of test/expr pairs. It evaluates each test one at a time. If a test returns logical true, cond evaluates and returns the value of the corresponding expr and doesn't evaluate any of the other tests or exprs. (cond) returns nil.
cond->
Takes an expression and a set of test/form pairs. Threads expr (via ->) through each form for which the corresponding test expression is true. Note that, unlike cond branching, cond-> threading does not short circuit after the first true test expression.
cond->>
Takes an expression and a set of test/form pairs. Threads expr (via ->>) through each form for which the corresponding test expression is true. Note that, unlike cond branching, cond->> threading does not short circuit after the first true test expression.
condp
Takes a binary predicate, an expression, and a set of clauses. Each clause can take the form of either: test-expr result-expr test-expr :>> result-fn Note :>> is an ordinary keyword. For each clause, (pred test-expr expr) is evaluated. If it returns logical true, the clause is a match. If a binary clause matches, the result-expr is returned, if a ternary clause matches, its result-fn, which must be a unary function, is called with the result of the predicate as its argument, the result of that call being the return value of condp. A single default expression can follow the clauses, and its value will be returned if no clause matches. If no default expression is provided and no clause matches, an IllegalArgumentException is thrown.
conj
conj[oin]. Returns a new collection with the xs 'added'. (conj nil item) returns (item). The 'addition' may happen at different 'places' depending on the concrete type.
conj!
Adds x to the transient collection, and return coll. The 'addition' may happen at different 'places' depending on the concrete type.
cons
Returns a new seq where x is the first element and seq is the rest.
constantly
Returns a function that takes any number of arguments and returns x.
construct-proxy
Takes a proxy class and any arguments for its superclass ctor and creates and returns an instance of the proxy.
contains?
Returns true if key is present in the given collection, otherwise returns false. Note that for numerically indexed collections like vectors and Java arrays, this tests if the numeric key is within the range of indexes. 'contains?' operates constant or logarithmic time; it will not perform a linear search for a value. See also 'some'.
count
Returns the number of items in the collection. (count nil) returns 0. Also works on strings, arrays, and Java Collections and Maps
counted?
Returns true if coll implements count in constant time
create-ns
Create a new namespace named by the symbol if one doesn't already exist, returns it or the already-existing namespace of the same name.
create-struct
Returns a structure basis object.
cycle
Returns a lazy (infinite!) sequence of repetitions of the items in coll."]
        "d" [ "dec
Returns a number one less than num. Does not auto-promote longs, will throw on overflow. See also: dec'
dec'
Returns a number one less than num. Supports arbitrary precision. See also: dec
decimal?
Returns true if n is a BigDecimal
declare
defs the supplied var names with no bindings, useful for making forward declarations.
def
Creates and interns or locates a global var with the name of symbol and a namespace of the value of the current namespace (*ns*). See http://clojure.org/special_forms for more information.
default-data-readers
Default map of data reader functions provided by Clojure. May be overridden by binding *data-readers*.
definline
Experimental - like defmacro, except defines a named function whose body is the expansion, calls to which may be expanded inline as if it were a macro. Cannot be used with variadic (&) args.
definterface
Creates a new Java interface with the given name and method sigs. The method return types and parameter types may be specified with type hints, defaulting to Object if omitted. (definterface MyInterface (^int method1 [x]) (^Bar method2 [^Baz b ^Quux q]))
defmacro
Like defn, but the resulting function name is declared as a macro and will be used as a macro by the compiler when it is called.
defmethod
Creates and installs a new method of multimethod associated with dispatch-value.
defmulti
Creates a new multimethod with the associated dispatch function. The docstring and attribute-map are optional. Options are key-value pairs and may be one of: :default The default dispatch value, defaults to :default :hierarchy The value used for hierarchical dispatch (e.g. ::square is-a ::shape) Hierarchies are type-like relationships that do not depend upon type inheritance. By default Clojure's multimethods dispatch off of a global hierarchy map. However, a hierarchy relationship can be created with the derive function used to augment the root ancestor created with make-hierarchy. Multimethods expect the value of the hierarchy option to be supplied as a reference type e.g. a var (i.e. via the Var-quote dispatch macro #' or the var special form).
defn
Same as (def name (fn [params* ] exprs*)) or (def name (fn ([params* ] exprs*)+)) with any doc-string or attrs added to the var metadata. prepost-map defines a map with optional keys :pre and :post that contain collections of pre or post conditions.
defn-
same as defn, yielding non-public def
defonce
defs name to have the root value of the expr iff the named var has no root value, else expr is unevaluated
defprotocol
A protocol is a named set of named methods and their signatures: (defprotocol AProtocolName ;optional doc string \"A doc string for AProtocol abstraction\" ;method signatures (bar [this a b] \")bar docs\") (baz [this a] [this a b] [this a b c] \"baz docs\")) No implementations are provided. Docs can be specified for the protocol overall and for each method. The above yields a set of polymorphic functions and a protocol object. All are namespace-qualified by the ns enclosing the definition The resulting functions dispatch on the type of their first argument, which is required and corresponds to the implicit target object ('this' in Java parlance). defprotocol is dynamic, has no special compile-time effect, and defines no new types or classes. Implementations of the protocol methods can be provided using extend. defprotocol will automatically generate a corresponding interface, with the same name as the protocol, i.e. given a protocol: my.ns/Protocol, an interface: my.ns.Protocol. The interface will have methods corresponding to the protocol functions, and the protocol will automatically work with instances of the interface. Note that you should not use this interface with deftype or reify, as they support the protocol directly: (defprotocol P (foo [this]) (bar-me [this] [this y])) (deftype Foo [a b c] P (foo [this] a) (bar-me [this] b) (bar-me [this y] (+ c y))) (bar-me (Foo. 1 2 3) 42) => 45 (foo (let [x 42] (reify P (foo [this] 17) (bar-me [this] x) (bar-me [this y] x)))) => 17
defrecord
(defrecord name [fields*] options* specs*) Currently there are no options. Each spec consists of a protocol or interface name followed by zero or more method bodies: protocol-or-interface-or-Object (methodName [args*] body)* Dynamically generates compiled bytecode for class with the given name, in a package with the same name as the current namespace, the given fields, and, optionally, methods for protocols and/or interfaces. The class will have the (immutable) fields named by fields, which can have type hints. Protocols/interfaces and methods are optional. The only methods that can be supplied are those declared in the protocols/interfaces. Note that method bodies are not closures, the local environment includes only the named fields, and those fields can be accessed directly. Method definitions take the form: (methodname [args*] body) The argument and return types can be hinted on the arg and methodname symbols. If not supplied, they will be inferred, so type hints should be reserved for disambiguation. Methods should be supplied for all methods of the desired protocol(s) and interface(s). You can also define overrides for methods of Object. Note that a parameter must be supplied to correspond to the target object ('this' in Java parlance). Thus methods for interfaces will take one more argument than do the interface declarations. Note also that recur calls to the method head should *not* pass the target object, it will be supplied automatically and can not be substituted. In the method bodies, the (unqualified) name can be used to name the class (for calls to new, instance? etc). The class will have implementations of several (clojure.lang) interfaces generated automatically: IObj (metadata support) and IPersistentMap, and all of their superinterfaces. In addition, defrecord will define type-and-value-based =, and will defined Java .hashCode and .equals consistent with the contract for java.util.Map. When AOT compiling, generates compiled bytecode for a class with the given name (a symbol), prepends the current ns as the package, and writes the .class file to the *compile-path* directory. Two constructors will be defined, one taking the designated fields followed by a metadata map (nil for none) and an extension field map (nil for none), and one taking only the fields (using nil for meta and extension fields). Note that the field names __meta and __extmap are currently reserved and should not be used when defining your own records. Given (defrecord TypeName ...), two factory functions will be defined: ->TypeName, taking positional parameters for the fields, and map->TypeName, taking a map of keywords to field values.
defstruct
Same as (def name (create-struct keys...))
deftype
(deftype name [fields*] options* specs*) Currently there are no options. Each spec consists of a protocol or interface name followed by zero or more method bodies: protocol-or-interface-or-Object (methodName [args*] body)* Dynamically generates compiled bytecode for class with the given name, in a package with the same name as the current namespace, the given fields, and, optionally, methods for protocols and/or interfaces. The class will have the (by default, immutable) fields named by fields, which can have type hints. Protocols/interfaces and methods are optional. The only methods that can be supplied are those declared in the protocols/interfaces. Note that method bodies are not closures, the local environment includes only the named fields, and those fields can be accessed directy. Fields can be qualified with the metadata :volatile-mutable true or :unsynchronized-mutable true, at which point (set! afield aval) will be supported in method bodies. Note well that mutable fields are extremely difficult to use correctly, and are present only to facilitate the building of higher level constructs, such as Clojure's reference types, in Clojure itself. They are for experts only - if the semantics and implications of :volatile-mutable or :unsynchronized-mutable are not immediately apparent to you, you should not be using them. Method definitions take the form: (methodname [args*] body) The argument and return types can be hinted on the arg and methodname symbols. If not supplied, they will be inferred, so type hints should be reserved for disambiguation. Methods should be supplied for all methods of the desired protocol(s) and interface(s). You can also define overrides for methods of Object. Note that a parameter must be supplied to correspond to the target object ('this' in Java parlance). Thus methods for interfaces will take one more argument than do the interface declarations. Note also that recur calls to the method head should *not* pass the target object, it will be supplied automatically and can not be substituted. In the method bodies, the (unqualified) name can be used to name the class (for calls to new, instance? etc). When AOT compiling, generates compiled bytecode for a class with the given name (a symbol), prepends the current ns as the package, and writes the .class file to the *compile-path* directory. One constructor will be defined, taking the designated fields. Note that the field names __meta and __extmap are currently reserved and should not be used when defining your own types. Given (deftype TypeName ...), a factory function called ->TypeName will be defined, taking positional parameters for the fields
delay
Takes a body of expressions and yields a Delay object that will invoke the body only the first time it is forced (with force or deref/@), and will cache the result and return it on all subsequent force calls. See also - realized?
delay?
returns true if x is a Delay created with delay
deliver
Delivers the supplied value to the promise, releasing any pending derefs. A subsequent call to deliver on a promise will have no effect.
denominator
Returns the denominator part of a Ratio.
deref
Also reader macro: @ref/@agent/@var/@atom/@delay/@future/@promise. Within a transaction, returns the in-transaction-value of ref, else returns the most-recently-committed value of ref. When applied to a var, agent or atom, returns its current state. When applied to a delay, forces it if not already forced. When applied to a future, will block if computation not complete. When applied to a promise, will block until a value is delivered. The variant taking a timeout can be used for blocking references (futures and promises), and will return timeout-val if the timeout (in milliseconds) is reached before a value is available. See also - realized?.
derive
Establishes a parent/child relationship between parent and tag. Parent must be a namespace-qualified symbol or keyword and child can be either a namespace-qualified symbol or keyword or a class. h must be a hierarchy obtained from make-hierarchy, if not supplied defaults to, and modifies, the global hierarchy.
descendants
Returns the immediate and indirect children of tag, through a relationship established via derive. h must be a hierarchy obtained from make-hierarchy, if not supplied defaults to the global hierarchy. Note: does not work on Java type inheritance relationships.
destructure
no doc
disj
disj[oin]. Returns a new set of the same (hashed/sorted) type, that does not contain key(s).
disj!
disj[oin]. Returns a transient set of the same (hashed/sorted) type, that does not contain key(s).
dissoc
dissoc[iate]. Returns a new map of the same (hashed/sorted) type, that does not contain a mapping for key(s).
dissoc!
Returns a transient map that doesn't contain a mapping for key(s).
distinct
Returns a lazy sequence of the elements of coll with duplicates removed
distinct?
Returns true if no two of the arguments are =
do
Evaluates the expressions in order and returns the value of the last. If no expressions are supplied, returns nil. See http://clojure.org/special_forms for more information.
doall
When lazy sequences are produced via functions that have side effects, any effects other than those needed to produce the first element in the seq do not occur until the seq is consumed. doall can be used to force any effects. Walks through the successive nexts of the seq, retains the head and returns it, thus causing the entire seq to reside in memory at one time.
dorun
When lazy sequences are produced via functions that have side effects, any effects other than those needed to produce the first element in the seq do not occur until the seq is consumed. dorun can be used to force any effects. Walks through the successive nexts of the seq, does not retain the head and returns nil.
doseq
Repeatedly executes body (presumably for side-effects) with bindings and filtering as provided by \"for\". Does not retain the head of the sequence. Returns nil.
dosync
Runs the exprs (in an implicit do) in a transaction that encompasses exprs and any nested calls. Starts a transaction if none is already running on this thread. Any uncaught exception will abort the transaction and flow out of dosync. The exprs may be run more than once, but any effects on Refs will be atomic.
dotimes
bindings => name n Repeatedly executes body (presumably for side-effects) with name bound to integers from 0 through n-1.
doto
Evaluates x then calls all of the methods and functions with the value of x supplied at the front of the given arguments. The forms are evaluated in order. Returns x. (doto (new java.util.HashMap) (.put \"a\" 1) (.put \"b\" 2))
double
Coerce to double
double-array
Creates an array of doubles
doubles
Casts to double[]
drop
Returns a lazy sequence of all but the first n items in coll.
drop-last
Return a lazy sequence of all but the last n (default 1) items in coll
drop-while
Returns a lazy sequence of the items in coll starting from the first item for which (pred item) returns logical false."]
        "e" [ "empty
Returns an empty collection of the same category as coll, or nil
EMPTY-NODE
no doc
empty?
Returns true if coll has no items - same as (not (seq coll)). Please use the idiom (seq x) rather than (not (empty? x))
ensure
Must be called in a transaction. Protects the ref from modification by other transactions. Returns the in-transaction-value of ref. Allows for more concurrency than (ref-set ref @ref)
enumeration-seq
Returns a seq on a java.util.Enumeration
error-handler
Returns the error-handler of agent a, or nil if there is none. See set-error-handler!
error-mode
Returns the error-mode of agent a. See set-error-mode!
eval
Evaluates the form data structure (not text!) and returns the result.
even?
Returns true if n is even, throws an exception if n is not an integer
every-pred
Takes a set of predicates and returns a function f that returns true if all of its composing predicates return a logical true value against all of its arguments, else it returns false. Note that f is short-circuiting in that it will stop execution on the first argument that triggers a logical false result against the original predicates.
every?
Returns true if (pred x) is logical true for every x in coll, else false.
ex-data
Returns exception data (a map) if ex is an IExceptionInfo. Otherwise returns nil.
ex-info
Create an instance of ExceptionInfo, a RuntimeException subclass that carries a map of additional data.
extend
Implementations of protocol methods can be provided using the extend construct: (extend AType AProtocol {:foo an-existing-fn :bar (fn [a b] ...) :baz (fn ([a]...) ([a b] ...)...)} BProtocol {...} ...) extend takes a type/class (or interface, see below), and one or more protocol + method map pairs. It will extend the polymorphism of the protocol's methods to call the supplied methods when an AType is provided as the first argument. Method maps are maps of the keyword-ized method names to ordinary fns. This facilitates easy reuse of existing fns and fn maps, for code reuse/mixins without derivation or composition. You can extend an interface to a protocol. This is primarily to facilitate interop with the host (e.g. Java) but opens the door to incidental multiple inheritance of implementation since a class can inherit from more than one interface, both of which extend the protocol. It is TBD how to specify which impl to use. You can extend a protocol on nil. If you are supplying the definitions explicitly (i.e. not reusing exsting functions or mixin maps), you may find it more convenient to use the extend-type or extend-protocol macros. Note that multiple independent extend clauses can exist for the same type, not all protocols need be defined in a single extend call. See also: extends?, satisfies?, extenders
extend-protocol
Useful when you want to provide several implementations of the same protocol all at once. Takes a single protocol and the implementation of that protocol for one or more types. Expands into calls to extend-type: (extend-protocol Protocol AType (foo [x] ...) (bar [x y] ...) BType (foo [x] ...) (bar [x y] ...) AClass (foo [x] ...) (bar [x y] ...) nil (foo [x] ...) (bar [x y] ...)) expands into: (do (clojure.core/extend-type AType Protocol (foo [x] ...) (bar [x y] ...)) (clojure.core/extend-type BType Protocol (foo [x] ...) (bar [x y] ...)) (clojure.core/extend-type AClass Protocol (foo [x] ...) (bar [x y] ...)) (clojure.core/extend-type nil Protocol (foo [x] ...) (bar [x y] ...)))
extend-type
A macro that expands into an extend call. Useful when you are supplying the definitions explicitly inline, extend-type automatically creates the maps required by extend. Propagates the class as a type hint on the first argument of all fns. (extend-type MyType Countable (cnt [c] ...) Foo (bar [x y] ...) (baz ([x] ...) ([x y & zs] ...))) expands into: (extend MyType Countable {:cnt (fn [c] ...)} Foo {:baz (fn ([x] ...) ([x y & zs] ...)) :bar (fn [x y] ...)})
extenders
Returns a collection of the types explicitly extending protocol
extends?
Returns true if atype extends protocol"]
        "f" [ "false?
Returns true if x is the value false, false otherwise.
ffirst
Same as (first (first x))
file-seq
A tree seq on java.io.Files
filter
Returns a lazy sequence of the items in coll for which (pred item) returns true. pred must be free of side-effects.
filterv
Returns a vector of the items in coll for which (pred item) returns true. pred must be free of side-effects.
finally
The exprs are evaluated and, if no exceptions occur, the value of the last is returned. If an exception occurs and catch clauses are provided, each is examined in turn and the first for which the thrown exception is an instance of the named class is considered a matching catch clause. If there is a matching catch clause, its exprs are evaluated in a context in which name is bound to the thrown exception, and the value of the last is the return value of the function. If there is no matching catch clause, the exception propagates out of the function. Before returning, normally or abnormally, any finally exprs will be evaluated for their side effects. See http://clojure.org/special_forms for more information.
find
Returns the map entry for key, or nil if key not present.
find-keyword
Returns a Keyword with the given namespace and name if one already exists. This function will not intern a new keyword. If the keyword has not already been interned, it will return nil. Do not use : in the keyword strings, it will be added automatically.
find-ns
Returns the namespace named by the symbol or nil if it doesn't exist.
find-protocol-impl
no doc
find-protocol-method
no doc
find-var
Returns the global var named by the namespace-qualified symbol, or nil if no var with that name.
first
Returns the first item in the collection. Calls seq on its argument. If coll is nil, returns nil.
flatten
Takes any nested combination of sequential things (lists, vectors, etc.) and returns their contents as a single, flat sequence. (flatten nil) returns an empty sequence.
float
Coerce to float
float-array
Creates an array of floats
float?
Returns true if n is a floating point number
floats
Casts to float[]
flush
Flushes the output stream that is the current value of *out*
fn
params => positional-params* , or positional-params* & next-param positional-param => binding-form next-param => binding-form name => symbol Defines a function
fn?
Returns true if x implements Fn, i.e. is an object created via fn.
fnext
Same as (first (next x))
fnil
Takes a function f, and returns a function that calls f, replacing a nil first argument to f with the supplied value x. Higher arity versions can replace arguments in the second and third positions (y, z). Note that the function f can take any number of arguments, not just the one(s) being nil-patched.
for
List comprehension. Takes a vector of one or more binding-form/collection-expr pairs, each followed by zero or more modifiers, and yields a lazy sequence of evaluations of expr. Collections are iterated in a nested fashion, rightmost fastest, and nested coll-exprs can refer to bindings created in prior binding-forms. Supported modifiers are: :let [binding-form expr ...], :while test, :when test. (take 100 (for [x (range 100000000) y (range 1000000) :while (< y x)] [x y]))
force
If x is a Delay, returns the (possibly cached) value of its expression, else returns x
format
Formats a string using java.lang.String.format, see java.util.Formatter for format string syntax
frequencies
Returns a map from distinct items in coll to the number of times they appear.
future
Takes a body of expressions and yields a future object that will invoke the body in another thread, and will cache the result and return it on all subsequent calls to deref/@. If the computation has not yet finished, calls to deref/@ will block, unless the variant of deref with timeout is used. See also - realized?.
future-call
Takes a function of no args and yields a future object that will invoke the function in another thread, and will cache the result and return it on all subsequent calls to deref/@. If the computation has not yet finished, calls to deref/@ will block, unless the variant of deref with timeout is used. See also - realized?.
future-cancel
Cancels the future, if possible.
future-cancelled?
Returns true if future f is cancelled
future-done?
Returns true if future f is done
future?
Returns true if x is a future"]
        "g" [ "gen-class
When compiling, generates compiled bytecode for a class with the given package-qualified :name (which, as all names in these parameters, can be a string or symbol), and writes the .class file to the *compile-path* directory. When not compiling, does nothing. The gen-class construct contains no implementation, as the implementation will be dynamically sought by the generated class in functions in an implementing Clojure namespace. Given a generated class org.mydomain.MyClass with a method named mymethod, gen-class will generate an implementation that looks for a function named by (str prefix mymethod) (default prefix: \"-\") in a Clojure namespace specified by :impl-ns (defaults to the current namespace). All inherited methods, generated methods, and init and main functions (see :methods, :init, and :main below) will be found similarly prefixed. By default, the static initializer for the generated class will attempt to load the Clojure support code for the class as a resource from the classpath, e.g. in the example case, ``org/mydomain/MyClass__init.class``. This behavior can be controlled by :load-impl-ns Note that methods with a maximum of 18 parameters are supported. In all subsequent sections taking types, the primitive types can be referred to by their Java names (int, float etc), and classes in the java.lang package can be used without a package qualifier. All other classes must be fully qualified. Options should be a set of key/value pairs, all except for :name are optional: :name aname The package-qualified name of the class to be generated :extends aclass Specifies the superclass, the non-private methods of which will be overridden by the class. If not provided, defaults to Object. :implements [interface ...] One or more interfaces, the methods of which will be implemented by the class. :init name If supplied, names a function that will be called with the arguments to the constructor. Must return [ [superclass-constructor-args] state] If not supplied, the constructor args are passed directly to the superclass constructor and the state will be nil :constructors {[param-types] [super-param-types], ...} By default, constructors are created for the generated class which match the signature(s) of the constructors for the superclass. This parameter may be used to explicitly specify constructors, each entry providing a mapping from a constructor signature to a superclass constructor signature. When you supply this, you must supply an :init specifier. :post-init name If supplied, names a function that will be called with the object as the first argument, followed by the arguments to the constructor. It will be called every time an object of this class is created, immediately after all the inherited constructors have completed. It's return value is ignored. :methods [ [name [param-types] return-type], ...] The generated class automatically defines all of the non-private methods of its superclasses/interfaces. This parameter can be used to specify the signatures of additional methods of the generated class. Static methods can be specified with ^{:static true} in the signature's metadata. Do not repeat superclass/interface signatures here. :main boolean If supplied and true, a static public main function will be generated. It will pass each string of the String[] argument as a separate argument to a function called (str prefix main). :factory name If supplied, a (set of) public static factory function(s) will be created with the given name, and the same signature(s) as the constructor(s). :state name If supplied, a public final instance field with the given name will be created. You must supply an :init function in order to provide a value for the state. Note that, though final, the state can be a ref or agent, supporting the creation of Java objects with transactional or asynchronous mutation semantics. :exposes {protected-field-name {:get name :set name}, ...} Since the implementations of the methods of the generated class occur in Clojure functions, they have no access to the inherited protected fields of the superclass. This parameter can be used to generate public getter/setter methods exposing the protected field(s) for use in the implementation. :exposes-methods {super-method-name exposed-name, ...} It is sometimes necessary to call the superclass' implementation of an overridden method. Those methods may be exposed and referred in the new method implementation by a local name. :prefix string Default: \"-\" Methods called e.g. Foo will be looked up in vars called prefixFoo in the implementing ns. :impl-ns name Default: the name of the current ns. Implementations of methods will be looked up in this namespace. :load-impl-ns boolean Default: true. Causes the static initializer for the generated class to reference the load code for the implementing namespace. Should be true when implementing-ns is the default, false if you intend to load the code via some other method.
gen-interface
When compiling, generates compiled bytecode for an interface with the given package-qualified :name (which, as all names in these parameters, can be a string or symbol), and writes the .class file to the *compile-path* directory. When not compiling, does nothing. In all subsequent sections taking types, the primitive types can be referred to by their Java names (int, float etc), and classes in the java.lang package can be used without a package qualifier. All other classes must be fully qualified. Options should be a set of key/value pairs, all except for :name are optional: :name aname The package-qualified name of the class to be generated :extends [interface ...] One or more interfaces, which will be extended by this interface. :methods [ [name [param-types] return-type], ...] This parameter is used to specify the signatures of the methods of the generated interface. Do not repeat superinterface signatures here.
gensym
Returns a new symbol with a unique name. If a prefix string is supplied, the name is prefix# where # is some unique number. If prefix is not supplied, the prefix is 'G__'.
get
Returns the value mapped to key, not-found or nil if key not present.
get-in
Returns the value in a nested associative structure, where ks is a sequence of keys. Returns nil if the key is not present, or the not-found value if supplied.
get-method
Given a multimethod and a dispatch value, returns the dispatch fn that would apply to that value, or nil if none apply and no default
get-proxy-class
Takes an optional single class followed by zero or more interfaces. If not supplied class defaults to Object. Creates an returns an instance of a proxy class derived from the supplied classes. The resulting value is cached and used for any subsequent requests for the same class set. Returns a Class object.
get-thread-bindings
Get a map with the Var/value pairs which is currently in effect for the current thread.
get-validator
Gets the validator-fn for a var/ref/agent/atom.
group-by
Returns a map of the elements of coll keyed by the result of f on each element. The value at each key will be a vector of the corresponding elements, in the order they appeared in coll."]
        "h" [ "hash
Returns the hash code of its argument. Note this is the hash code consistent with =, and thus is different than .hashCode for Integer, Short, Byte and Clojure collections.
hash-combine
no doc
hash-map
keyval => key val Returns a new hash map with supplied mappings. If any keys are equal, they are handled as if by repeated uses of assoc.
hash-ordered-coll
Returns the hash code, consistent with =, for an external ordered collection implementing Iterable. See http://clojure.org/data_structures#hash for full algorithms.
hash-set
Returns a new hash set with supplied keys. Any equal keys are handled as if by repeated uses of conj.
hash-unordered-coll
Returns the hash code, consistent with =, for an external unordered collection implementing Iterable. For maps, the iterator should return map entries whose hash is computed as (hash-ordered-coll [k v]). See http://clojure.org/data_structures#hash for full algorithms."]
        "i" [ "identical?
Tests if 2 arguments are the same object
identity
Returns its argument.
if
Evaluates test.
if-let
bindings => binding-form test If test is true, evaluates then with binding-form bound to the value of test, if not, yields else
if-not
Evaluates test. If logical false, evaluates and returns then expr, otherwise else expr, if supplied, else nil.
if-some
bindings => binding-form test If test is not nil, evaluates then with binding-form bound to the value of test, if not, yields else
ifn?
Returns true if x implements IFn. Note that many data structures (e.g. sets and maps) implement IFn
import
import-list => (package-symbol class-name-symbols*) For each name in class-name-symbols, adds a mapping from name to the class named by package.name to the current namespace. Use :import in the ns macro in preference to calling this directly.
in-ns
Sets *ns* to the namespace named by the symbol, creating it if needed.
inc
Returns a number one greater than num. Does not auto-promote longs, will throw on overflow. See also: inc'
inc'
Returns a number one greater than num. Supports arbitrary precision. See also: inc
init-proxy
Takes a proxy instance and a map of strings (which must correspond to methods of the proxy superclass/superinterfaces) to fns (which must take arguments matching the corresponding method, plus an additional (explicit) first arg corresponding to this, and sets the proxy's fn map. Returns the proxy.
instance?
Evaluates x and tests if it is an instance of the class c. Returns true or false
int
Coerce to int
int-array
Creates an array of ints
integer?
Returns true if n is an integer
interleave
Returns a lazy seq of the first item in each coll, then the second etc.
intern
Finds or creates a var named by the symbol name in the namespace ns (which can be a symbol or a namespace), setting its root binding to val if supplied. The namespace must exist. The var will adopt any metadata from the name symbol. Returns the var.
interpose
Returns a lazy seq of the elements of coll separated by sep
into
Returns a new coll consisting of to-coll with all of the items of from-coll conjoined.
into-array
Returns an array with components set to the values in aseq. The array's component type is type if provided, or the type of the first value in aseq if present, or Object. All values in aseq must be compatible with the component type. Class objects for the primitive types can be obtained using, e.g., Integer/TYPE.
ints
Casts to int[]
io!
If an io! block occurs in a transaction, throws an IllegalStateException, else runs body in an implicit do. If the first expression in body is a literal string, will use that as the exception message.
isa?
Returns true if (= child parent), or child is directly or indirectly derived from parent, either via a Java type inheritance relationship or a relationship established via derive. h must be a hierarchy obtained from make-hierarchy, if not supplied defaults to the global hierarchy
iterate
Returns a lazy sequence of x, (f x), (f (f x)) etc. f must be free of side-effects
iterator-seq
Returns a seq on a java.util.Iterator. Note that most collections providing iterators implement Iterable and thus support seq directly."]
        "j" [ "juxt
Takes a set of functions and returns a fn that is the juxtaposition of those fns. The returned fn takes a variable number of args, and returns a vector containing the result of applying each fn to the args (left-to-right). ((juxt a b c) x) => [(a x) (b x) (c x)]"]
        "k" [ "keep
Returns a lazy sequence of the non-nil results of (f item). Note, this means false return values will be included. f must be free of side-effects.
keep-indexed
Returns a lazy sequence of the non-nil results of (f index item). Note, this means false return values will be included. f must be free of side-effects.
key
Returns the key of the map entry.
keys
Returns a sequence of the map's keys, in the same order as (seq map).
keyword
Returns a Keyword with the given namespace and name. Do not use : in the keyword strings, it will be added automatically.
keyword?
Return true if x is a Keyword"]
        "l" [ "last
Return the last item in coll, in linear time
lazy-cat
Expands to code which yields a lazy sequence of the concatenation of the supplied colls. Each coll expr is not evaluated until it is needed. (lazy-cat xs ys zs) === (concat (lazy-seq xs) (lazy-seq ys) (lazy-seq zs))
lazy-seq
Takes a body of expressions that returns an ISeq or nil, and yields a Seqable object that will invoke the body only the first time seq is called, and will cache the result and return it on all subsequent seq calls. See also - realized?
let
binding => binding-form init-expr Evaluates the exprs in a lexical context in which the symbols in the binding-forms are bound to their respective init-exprs or parts therein.
letfn
fnspec ==> (fname [params*] exprs) or (fname ([params*] exprs)+) Takes a vector of function specs and a body, and generates a set of bindings of functions to their names. All of the names are available in all of the definitions of the functions, as well as the body.
line-seq
Returns the lines of text from rdr as a lazy sequence of strings. rdr must implement java.io.BufferedReader.
list
Creates a new list containing the items.
list*
Creates a new list containing the items prepended to the rest, the last of which will be treated as a sequence.
list?
Returns true if x implements IPersistentList
load
Loads Clojure code from resources in classpath. A path is interpreted as classpath-relative if it begins with a slash or relative to the root directory for the current namespace otherwise.
load-file
Sequentially read and evaluate the set of forms contained in the file.
load-reader
Sequentially read and evaluate the set of forms contained in the stream/file
load-string
Sequentially read and evaluate the set of forms contained in the string
loaded-libs
Returns a sorted set of symbols naming the currently loaded libs
locking
Executes exprs in an implicit do, while holding the monitor of x. Will release the monitor of x in all circumstances.
long
Coerce to long
long-array
Creates an array of longs
longs
Casts to long[]
loop
Evaluates the exprs in a lexical context in which the symbols in the binding-forms are bound to their respective init-exprs or parts therein. Acts as a recur target."]
        "m" [ "macroexpand
Repeatedly calls macroexpand-1 on form until it no longer represents a macro form, then returns it. Note neither macroexpand-1 nor macroexpand expand macros in subforms.
macroexpand-1
If form represents a macro form, returns its expansion, else returns form.
make-array
Creates and returns an array of instances of the specified class of the specified dimension(s). Note that a class object is required. Class objects can be obtained by using their imported or fully-qualified name. Class objects for the primitive types can be obtained using, e.g., Integer/TYPE.
make-hierarchy
Creates a hierarchy object for use with derive, isa? etc.
map
Returns a lazy sequence consisting of the result of applying f to the set of first items of each coll, followed by applying f to the set of second items in each coll, until any one of the colls is exhausted. Any remaining items in other colls are ignored. Function f should accept number-of-colls arguments.
map-indexed
Returns a lazy sequence consisting of the result of applying f to 0 and the first item of coll, followed by applying f to 1 and the second item in coll, etc, until coll is exhausted. Thus function f should accept 2 arguments, index and item.
map?
Return true if x implements IPersistentMap
mapcat
Returns the result of applying concat to the result of applying map to f and colls. Thus function f should return a collection.
mapv
Returns a vector consisting of the result of applying f to the set of first items of each coll, followed by applying f to the set of second items in each coll, until any one of the colls is exhausted. Any remaining items in other colls are ignored. Function f should accept number-of-colls arguments.
max
Returns the greatest of the nums.
max-key
Returns the x for which (k x), a number, is greatest.
memfn
Expands into code that creates a fn that expects to be passed an object and any args and calls the named instance method on the object passing the args. Use when you want to treat a Java method as a first-class fn. name may be type-hinted with the method receiver's type in order to avoid reflective calls.
memoize
Returns a memoized version of a referentially transparent function. The memoized version of the function keeps a cache of the mapping from arguments to results and, when calls with the same arguments are repeated often, has higher performance at the expense of higher memory use.
merge
Returns a map that consists of the rest of the maps conj-ed onto the first. If a key occurs in more than one map, the mapping from the latter (left-to-right) will be the mapping in the result.
merge-with
Returns a map that consists of the rest of the maps conj-ed onto the first. If a key occurs in more than one map, the mapping(s) from the latter (left-to-right) will be combined with the mapping in the result by calling (f val-in-result val-in-latter).
meta
Returns the metadata of obj, returns nil if there is no metadata.
method-sig
no doc
methods
Given a multimethod, returns a map of dispatch values -> dispatch fns
min
Returns the least of the nums.
min-key
Returns the x for which (k x), a number, is least.
mix-collection-hash
Mix final collection hash for ordered or unordered collections. hash-basis is the combined collection hash, count is the number of elements included in the basis. Note this is the hash code consistent with =, different from .hashCode. See http://clojure.org/data_structures#hash for full algorithms.
mod
Modulus of num and div. Truncates toward negative infinity.
munge
no doc"]
        "n" [ "name
Returns the name String of a string, symbol or keyword.
namespace
Returns the namespace String of a symbol or keyword, or nil if not present.
namespace-munge
Convert a Clojure namespace name to a legal Java package name.
neg?
Returns true if num is less than zero, else false
newline
Writes a platform-specific newline to *out*
next
Returns a seq of the items after the first. Calls seq on its argument. If there are no more items, returns nil.
nfirst
Same as (next (first x))
nil?
Returns true if x is nil, false otherwise.
nnext
Same as (next (next x))
not
Returns true if x is logical false, false otherwise.
not-any?
Returns false if (pred x) is logical true for any x in coll, else true.
not-empty
If coll is empty, returns nil, else coll
not-every?
Returns false if (pred x) is logical true for every x in coll, else true.
not=
Same as (not (= obj1 obj2))
ns
Sets *ns* to the namespace named by name (unevaluated), creating it if needed. references can be zero or more of: (:refer-clojure ...) (:require ...) (:use ...) (:import ...) (:load ...) (:gen-class) with the syntax of refer-clojure/require/use/import/load/gen-class respectively, except the arguments are unevaluated and need not be quoted. (:gen-class ...), when supplied, defaults to :name corresponding to the ns name, :main true, :impl-ns same as ns, and :init-impl-ns true. All options of gen-class are supported. The :gen-class directive is ignored when not compiling. If :gen-class is not supplied, when compiled only an nsname__init.class will be generated. If :refer-clojure is not used, a default (refer 'clojure.core) is used. Use of ns is preferred to individual calls to in-ns/require/use/import: (ns foo.bar (:refer-clojure :exclude [ancestors printf]) (:require (clojure.contrib sql combinatorics)) (:use (my.lib this that)) (:import (java.util Date Timer Random) (java.sql Connection Statement)))
ns-aliases
Returns a map of the aliases for the namespace.
ns-imports
Returns a map of the import mappings for the namespace.
ns-interns
Returns a map of the intern mappings for the namespace.
ns-map
Returns a map of all the mappings for the namespace.
ns-name
Returns the name of the namespace, a symbol.
ns-publics
Returns a map of the public intern mappings for the namespace.
ns-refers
Returns a map of the refer mappings for the namespace.
ns-resolve
Returns the var or Class to which a symbol will be resolved in the namespace (unless found in the environment), else nil. Note that if the symbol is fully qualified, the var/Class to which it resolves need not be present in the namespace.
ns-unalias
Removes the alias for the symbol from the namespace.
ns-unmap
Removes the mappings for the symbol from the namespace.
nth
Returns the value at the index. get returns nil if index out of bounds, nth throws an exception unless not-found is supplied. nth also works for strings, Java arrays, regex Matchers and Lists, and, in O(n) time, for sequences.
nthnext
Returns the nth next of coll, (seq coll) when n is 0.
nthrest
Returns the nth rest of coll, coll when n is 0.
num
Coerce to Number
number?
Returns true if x is a Number
numerator
Returns the numerator part of a Ratio."]
        "o" [ "object-array
Creates an array of objects
odd?
Returns true if n is odd, throws an exception if n is not an integer
or
Evaluates exprs one at a time, from left to right. If a form returns a logical true value, or returns that value and doesn't evaluate any of the other expressions, otherwise it returns the value of the last expression. (or) returns nil."]
        "p" [ "parents
Returns the immediate parents of tag, either via a Java type inheritance relationship or a relationship established via derive. h must be a hierarchy obtained from make-hierarchy, if not supplied defaults to the global hierarchy
partial
Takes a function f and fewer than the normal arguments to f, and returns a fn that takes a variable number of additional args. When called, the returned function calls f with args + additional args.
partition
Returns a lazy sequence of lists of n items each, at offsets step apart. If step is not supplied, defaults to n, i.e. the partitions do not overlap. If a pad collection is supplied, use its elements as necessary to complete last partition upto n items. In case there are not enough padding elements, return a partition with less than n items.
partition-all
Returns a lazy sequence of lists like partition, but may include partitions with fewer than n items at the end.
partition-by
Applies f to each value in coll, splitting it each time f returns a new value. Returns a lazy seq of partitions.
pcalls
Executes the no-arg fns in parallel, returning a lazy sequence of their values
peek
For a list or queue, same as first, for a vector, same as, but much more efficient than, last. If the collection is empty, returns nil.
persistent!
Returns a new, persistent version of the transient collection, in constant time. The transient collection cannot be used after this call, any such use will throw an exception.
pmap
Like map, except f is applied in parallel. Semi-lazy in that the parallel computation stays ahead of the consumption, but doesn't realize the entire result unless required. Only useful for computationally intensive functions where the time of f dominates the coordination overhead.
pop
For a list or queue, returns a new list/queue without the first item, for a vector, returns a new vector without the last item. If the collection is empty, throws an exception. Note - not the same as next/butlast.
pop!
Removes the last item from a transient vector. If the collection is empty, throws an exception. Returns coll
pop-thread-bindings
Pop one set of bindings pushed with push-binding before. It is an error to pop bindings without pushing before.
pos?
Returns true if num is greater than zero, else false
pr
Prints the object(s) to the output stream that is the current value of *out*. Prints the object(s), separated by spaces if there is more than one. By default, pr and prn print in a way that objects can be read by the reader
pr-str
pr to a string, returning it
prefer-method
Causes the multimethod to prefer matches of dispatch-val-x over dispatch-val-y when there is a conflict
prefers
Given a multimethod, returns a map of preferred value -> set of other values
primitives-classnames
no doc
print
Prints the object(s) to the output stream that is the current value of *out*. print and println produce output for human consumption.
print-ctor
no doc
print-dup
no doc
print-method
no doc
print-simple
no doc
print-str
print to a string, returning it
printf
Prints formatted output, as per format
println
Same as print followed by (newline)
println-str
println to a string, returning it
prn
Same as pr followed by (newline). Observes *flush-on-newline*
prn-str
prn to a string, returning it
promise
Returns a promise object that can be read with deref/@, and set, once only, with deliver. Calls to deref/@ prior to delivery will block, unless the variant of deref with timeout is used. All subsequent derefs will return the same delivered value without blocking. See also - realized?.
proxy
class-and-interfaces - a vector of class names args - a (possibly empty) vector of arguments to the superclass constructor. f => (name [params*] body) or (name ([params*] body) ([params+] body) ...) Expands to code which creates a instance of a proxy class that implements the named class/interface(s) by calling the supplied fns. A single class, if provided, must be first. If not provided it defaults to Object. The interfaces names must be valid interface types. If a method fn is not provided for a class method, the superclass methd will be called. If a method fn is not provided for an interface method, an UnsupportedOperationException will be thrown should it be called. Method fns are closures and can capture the environment in which proxy is called. Each method fn takes an additional implicit first arg, which is bound to 'this. Note that while method fns can be provided to override protected methods, they have no other access to protected members, nor to super, as these capabilities cannot be proxied.
proxy-call-with-super
no doc
proxy-mappings
Takes a proxy instance and returns the proxy's fn map.
proxy-name
no doc
proxy-super
Use to call a superclass method in the body of a proxy method. Note, expansion captures 'this
push-thread-bindings
WARNING: This is a low-level function. Prefer high-level macros like binding where ever possible. Takes a map of Var/value pairs. Binds each Var to the associated value for the current thread. Each call *MUST* be accompanied by a matching call to pop-thread-bindings wrapped in a try-finally! (push-thread-bindings bindings) (try ... (finally (pop-thread-bindings)))
pvalues
Returns a lazy sequence of the values of the exprs, which are evaluated in parallel"]
        "q" [ "quot
quot[ient] of dividing numerator by denominator.
quote
Yields the unevaluated form. See http://clojure.org/special_forms for more information."]
        "r" [ "rand
Returns a random floating point number between 0 (inclusive) and n (default 1) (exclusive).
rand-int
Returns a random integer between 0 (inclusive) and n (exclusive).
rand-nth
Return a random element of the (sequential) collection. Will have the same performance characteristics as nth for the given collection.
range
Returns a lazy seq of nums from start (inclusive) to end (exclusive), by step, where start defaults to 0, step to 1, and end to infinity. When step is equal to 0, returns an infinite sequence of start. When start is equal to end, returns empty list.
ratio?
Returns true if n is a Ratio
rational?
Returns true if n is a rational number
rationalize
returns the rational value of num
re-find
Returns the next regex match, if any, of string to pattern, using java.util.regex.Matcher.find(). Uses re-groups to return the groups.
re-groups
Returns the groups from the most recent match/find. If there are no nested groups, returns a string of the entire match. If there are nested groups, returns a vector of the groups, the first element being the entire match.
re-matcher
Returns an instance of java.util.regex.Matcher, for use, e.g. in re-find.
re-matches
Returns the match, if any, of string to pattern, using java.util.regex.Matcher.matches(). Uses re-groups to return the groups.
re-pattern
Returns an instance of java.util.regex.Pattern, for use, e.g. in re-matcher.
re-seq
Returns a lazy sequence of successive matches of pattern in string, using java.util.regex.Matcher.find(), each such match processed with re-groups.
read
Reads the next object from stream, which must be an instance of java.io.PushbackReader or some derivee. stream defaults to the current value of *in*. Note that read can execute code (controlled by *read-eval*), and as such should be used only with trusted sources. For data structure interop use clojure.edn/read
read-line
Reads the next line from stream that is the current value of *in* .
read-string
Reads one object from the string s. Note that read-string can execute code (controlled by *read-eval*), and as such should be used only with trusted sources. For data structure interop use clojure.edn/read-string
realized?
Returns true if a value has been produced for a promise, delay, future or lazy sequence.
record?
Returns true if x is a record
recur
Evaluates the exprs in order, then, in parallel, rebinds the bindings of the recursion point to the values of the exprs. See http://clojure.org/special_forms for more information.
reduce
f should be a function of 2 arguments. If val is not supplied, returns the result of applying f to the first 2 items in coll, then applying f to that result and the 3rd item, etc. If coll contains no items, f must accept no arguments as well, and reduce returns the result of calling f with no arguments. If coll has only 1 item, it is returned and f is not called. If val is supplied, returns the result of applying f to val and the first item in coll, then applying f to that result and the 2nd item, etc. If coll contains no items, returns val and f is not called.
reduce-kv
Reduces an associative collection. f should be a function of 3 arguments. Returns the result of applying f to init, the first key and the first value in coll, then applying f to that result and the 2nd key and value, etc. If coll contains no entries, returns init and f is not called. Note that reduce-kv is supported on vectors, where the keys will be the ordinals.
reduced
Wraps x in a way such that a reduce will terminate with the value x
reduced?
Returns true if x is the result of a call to reduced
reductions
Returns a lazy seq of the intermediate values of the reduction (as per reduce) of coll by f, starting with init.
ref
Creates and returns a Ref with an initial value of x and zero or more options (in any order): :meta metadata-map :validator validate-fn :min-history (default 0) :max-history (default 10) If metadata-map is supplied, it will become the metadata on the ref. validate-fn must be nil or a side-effect-free fn of one argument, which will be passed the intended new state on any state change. If the new state is unacceptable, the validate-fn should return false or throw an exception. validate-fn will be called on transaction commit, when all refs have their final values. Normally refs accumulate history dynamically as needed to deal with read demands. If you know in advance you will need history you can set :min-history to ensure it will be available when first needed (instead of after a read fault). History is limited, and the limit can be set with :max-history.
ref-history-count
Returns the history count of a ref
ref-max-history
Gets the max-history of a ref, or sets it and returns the ref
ref-min-history
Gets the min-history of a ref, or sets it and returns the ref
ref-set
Must be called in a transaction. Sets the value of ref. Returns val.
refer
refers to all public vars of ns, subject to filters. filters can include at most one each of: :exclude list-of-symbols :only list-of-symbols :rename map-of-fromsymbol-tosymbol For each public interned var in the namespace named by the symbol, adds a mapping from the name of the var to the var to the current namespace. Throws an exception if name is already mapped to something else in the current namespace. Filters can be used to select a subset, via inclusion or exclusion, or to provide a mapping to a symbol different from the var's name, in order to prevent clashes. Use :use in the ns macro in preference to calling this directly.
refer-clojure
Same as (refer 'clojure.core )
reify
reify is a macro with the following structure: (reify options* specs*) Currently there are no options. Each spec consists of the protocol or interface name followed by zero or more method bodies: protocol-or-interface-or-Object (methodName [args+] body)* Methods should be supplied for all methods of the desired protocol(s) and interface(s). You can also define overrides for methods of Object. Note that the first parameter must be supplied to correspond to the target object ('this' in Java parlance). Thus methods for interfaces will take one more argument than do the interface declarations. Note also that recur calls to the method head should *not* pass the target object, it will be supplied automatically and can not be substituted. The return type can be indicated by a type hint on the method name, and arg types can be indicated by a type hint on arg names. If you leave out all hints, reify will try to match on same name/arity method in the protocol(s)/interface(s) - this is preferred. If you supply any hints at all, no inference is done, so all hints (or default of Object) must be correct, for both arguments and return type. If a method is overloaded in a protocol/interface, multiple independent method definitions must be supplied. If overloaded with same arity in an interface you must specify complete hints to disambiguate - a missing hint implies Object. recur works to method heads The method bodies of reify are lexical closures, and can refer to the surrounding local scope: (str (let [f \"foo\"] (reify Object (toString [this] f)))) == \"foo\" (seq (let [f \"foo\"] (reify clojure.lang.Seqable (seq [this] (seq f))))) == (\f \\o \\o)) reify always implements clojure.lang.IObj and transfers meta data of the form to the created object. (meta ^{:k :v} (reify Object (toString [this] \"foo\"))) == {:k :v}
release-pending-sends
Normally, actions sent directly or indirectly during another action are held until the action completes (changes the agent's state). This function can be used to dispatch any pending sent actions immediately. This has no impact on actions sent during a transaction, which are still held until commit. If no action is occurring, does nothing. Returns the number of actions dispatched.
rem
remainder of dividing numerator by denominator.
remove
Returns a lazy sequence of the items in coll for which (pred item) returns false. pred must be free of side-effects.
remove-all-methods
Removes all of the methods of multimethod.
remove-method
Removes the method of multimethod associated with dispatch-value.
remove-ns
Removes the namespace named by the symbol. Use with caution. Cannot be used to remove the clojure namespace.
remove-watch
Removes a watch (set by add-watch) from a reference
repeat
Returns a lazy (infinite!, or length n if supplied) sequence of xs.
repeatedly
Takes a function of no args, presumably with side effects, and returns an infinite (or length n if supplied) lazy sequence of calls to it
replace
Given a map of replacement pairs and a vector/collection, returns a vector/seq with any elements = a key in smap replaced with the corresponding val in smap
replicate
DEPRECATED: Use 'repeat' instead. Returns a lazy seq of n xs.
require
Loads libs, skipping any that are already loaded. Each argument is either a libspec that identifies a lib, a prefix list that identifies multiple libs whose names share a common prefix, or a flag that modifies how all the identified libs are loaded. Use :require in the ns macro in preference to calling this directly. Libs A 'lib' is a named set of resources in classpath whose contents define a library of Clojure code. Lib names are symbols and each lib is associated with a Clojure namespace and a Java package that share its name. A lib's name also locates its root directory within classpath using Java's package name to classpath-relative path mapping. All resources in a lib should be contained in the directory structure under its root directory. All definitions a lib makes should be in its associated namespace. 'require loads a lib by loading its root resource. The root resource path is derived from the lib name in the following manner: Consider a lib named by the symbol 'x.y.z; it has the root directory /x/y/, and its root resource is /x/y/z.clj. The root resource should contain code to create the lib's namespace (usually by using the ns macro) and load any additional lib resources. Libspecs A libspec is a lib name or a vector containing a lib name followed by options expressed as sequential keywords and arguments. Recognized options: :as takes a symbol as its argument and makes that symbol an alias to the lib's namespace in the current namespace. :refer takes a list of symbols to refer from the namespace or the :all keyword to bring in all public vars. Prefix Lists It's common for Clojure code to depend on several libs whose names have the same prefix. When specifying libs, prefix lists can be used to reduce repetition. A prefix list contains the shared prefix followed by libspecs with the shared prefix removed from the lib names. After removing the prefix, the names that remain must not contain any periods. Flags A flag is a keyword. Recognized flags: :reload, :reload-all, :verbose :reload forces loading of all the identified libs even if they are already loaded :reload-all implies :reload and also forces loading of all libs that the identified libs directly or indirectly load via require or use :verbose triggers printing information about each load, alias, and refer Example: The following would load the libraries clojure.zip and clojure.set abbreviated as 's'. (require '(clojure zip [set :as s]))
reset!
Sets the value of atom to newval without regard for the current value. Returns newval.
reset-meta!
Atomically resets the metadata for a namespace/var/ref/agent/atom
resolve
same as (ns-resolve *ns* symbol) or (ns-resolve *ns* &env symbol)
rest
Returns a possibly empty seq of the items after the first. Calls seq on its argument.
restart-agent
When an agent is failed, changes the agent state to new-state and then un-fails the agent so that sends are allowed again. If a :clear-actions true option is given, any actions queued on the agent that were being held while it was failed will be discarded, otherwise those held actions will proceed. The new-state must pass the validator if any, or restart will throw an exception and the agent will remain failed with its old state and error. Watchers, if any, will NOT be notified of the new state. Throws an exception if the agent is not failed.
resultset-seq
Creates and returns a lazy sequence of structmaps corresponding to the rows in the java.sql.ResultSet rs
reverse
Returns a seq of the items in coll in reverse order. Not lazy.
reversible?
Returns true if coll implements Reversible
rseq
Returns, in constant time, a seq of the items in rev (which can be a vector or sorted-map), in reverse order. If rev is empty returns nil
rsubseq
sc must be a sorted collection, test(s) one of <, <=, > or >=. Returns a reverse seq of those entries with keys ek for which (test (.. sc comparator (compare ek key)) 0) is true"]
        "s" [ "satisfies?
Returns true if x satisfies the protocol
second
Same as (first (next x))
select-keys
Returns a map containing only those entries in map whose key is in keys
send
Dispatch an action to an agent. Returns the agent immediately. Subsequently, in a thread from a thread pool, the state of the agent will be set to the value of: (apply action-fn state-of-agent args)
send-off
Dispatch a potentially blocking action to an agent. Returns the agent immediately. Subsequently, in a separate thread, the state of the agent will be set to the value of: (apply action-fn state-of-agent args)
send-via
Dispatch an action to an agent. Returns the agent immediately. Subsequently, in a thread supplied by executor, the state of the agent will be set to the value of: (apply action-fn state-of-agent args)
seq
Returns a seq on the collection. If the collection is empty, returns nil. (seq nil) returns nil. seq also works on Strings, native Java arrays (of reference types) and any objects that implement Iterable.
seq?
Return true if x implements ISeq
seque
Creates a queued seq on another (presumably lazy) seq s. The queued seq will produce a concrete seq in the background, and can get up to n items ahead of the consumer. n-or-q can be an integer n buffer size, or an instance of java.util.concurrent BlockingQueue. Note that reading from a seque can block if the reader gets ahead of the producer.
sequence
Coerces coll to a (possibly empty) sequence, if it is not already one. Will not force a lazy seq. (sequence nil) yields ()
sequential?
Returns true if coll implements Sequential
set
Returns a set of the distinct elements of coll.
set!
Assignment special form. When the first operand is a field member access form, the assignment is to the corresponding field. If it is an instance field, the instance expr will be evaluated, then the expr. In all cases the value of expr is returned. Note - you cannot assign to function params or local bindings. Only Java fields, Vars, Refs and Agents are mutable in Clojure. See http://clojure.org/special_forms for more information.
set-agent-send-executor!
Sets the ExecutorService to be used by send
set-agent-send-off-executor!
Sets the ExecutorService to be used by send-off
set-error-handler!
Sets the error-handler of agent a to handler-fn. If an action being run by the agent throws an exception or doesn't pass the validator fn, handler-fn will be called with two arguments: the agent and the exception.
set-error-mode!
Sets the error-mode of agent a to mode-keyword, which must be either :fail or :continue. If an action being run by the agent throws an exception or doesn't pass the validator fn, an error-handler may be called (see set-error-handler!), after which, if the mode is :continue, the agent will continue as if neither the action that caused the error nor the error itself ever happened. If the mode is :fail, the agent will become failed and will stop accepting new 'send' and 'send-off' actions, and any previously queued actions will be held until a 'restart-agent'. Deref will still work, returning the state of the agent before the error.
set-validator!
Sets the validator-fn for a var/ref/agent/atom. validator-fn must be nil or a side-effect-free fn of one argument, which will be passed the intended new state on any state change. If the new state is unacceptable, the validator-fn should return false or throw an exception. If the current state (root value if var) is not acceptable to the new validator, an exception will be thrown and the validator will not be changed.
set?
Returns true if x implements IPersistentSet
short
Coerce to short
short-array
Creates an array of shorts
shorts
Casts to shorts[]
shuffle
Return a random permutation of coll
shutdown-agents
Initiates a shutdown of the thread pools that back the agent system. Running actions will complete, but no new actions will be accepted
slurp
Opens a reader on f and reads all its contents, returning a string. See clojure.java.io/reader for a complete list of supported arguments.
some
Returns the first logical true value of (pred x) for any x in coll, else nil. One common idiom is to use a set as pred, for example this will return :fred if :fred is in the sequence, otherwise nil: (some #{:fred} coll)
some->
When expr is not nil, threads it into the first form (via ->), and when that result is not nil, through the next etc
some->>
When expr is not nil, threads it into the first form (via ->>), and when that result is not nil, through the next etc
some-fn
Takes a set of predicates and returns a function f that returns the first logical true value returned by one of its composing predicates against any of its arguments, else it returns logical false. Note that f is short-circuiting in that it will stop execution on the first argument that triggers a logical true result against the original predicates.
some?
Returns true if x is not nil, false otherwise.
sort
Returns a sorted sequence of the items in coll. If no comparator is supplied, uses compare. comparator must implement java.util.Comparator. If coll is a Java array, it will be modified. To avoid this, sort a copy of the array.
sort-by
Returns a sorted sequence of the items in coll, where the sort order is determined by comparing (keyfn item). If no comparator is supplied, uses compare. comparator must implement java.util.Comparator. If coll is a Java array, it will be modified. To avoid this, sort a copy of the array.
sorted-map
keyval => key val Returns a new sorted map with supplied mappings. If any keys are equal, they are handled as if by repeated uses of assoc.
sorted-map-by
keyval => key val Returns a new sorted map with supplied mappings, using the supplied comparator. If any keys are equal, they are handled as if by repeated uses of assoc.
sorted-set
Returns a new sorted set with supplied keys. Any equal keys are handled as if by repeated uses of conj.
sorted-set-by
Returns a new sorted set with supplied keys, using the supplied comparator. Any equal keys are handled as if by repeated uses of conj.
sorted?
Returns true if coll implements Sorted
special-symbol?
Returns true if s names a special form
spit
Opposite of slurp. Opens f with writer, writes content, then closes f. Options passed to clojure.java.io/writer.
split-at
Returns a vector of [(take n coll) (drop n coll)]
split-with
Returns a vector of [(take-while pred coll) (drop-while pred coll)]
str
With no args, returns the empty string. With one arg x, returns x.toString(). (str nil) returns the empty string. With more than one arg, returns the concatenation of the str values of the args.
string?
Return true if x is a String
struct
Returns a new structmap instance with the keys of the structure-basis. vals must be supplied for basis keys in order - where values are not supplied they will default to nil.
struct-map
Returns a new structmap instance with the keys of the structure-basis. keyvals may contain all, some or none of the basis keys - where values are not supplied they will default to nil. keyvals can also contain keys not in the basis.
subs
Returns the substring of s beginning at start inclusive, and ending at end (defaults to length of string), exclusive.
subseq
sc must be a sorted collection, test(s) one of <, <=, > or >=. Returns a seq of those entries with keys ek for which (test (.. sc comparator (compare ek key)) 0) is true
subvec
Returns a persistent vector of the items in vector from start (inclusive) to end (exclusive). If end is not supplied, defaults to (count vector). This operation is O(1) and very fast, as the resulting vector shares structure with the original and no trimming is done.
supers
Returns the immediate and indirect superclasses and interfaces of c, if any
swap!
Atomically swaps the value of atom to be: (apply f current-value-of-atom args). Note that f may be called multiple times, and thus should be free of side effects. Returns the value that was swapped in.
symbol
Returns a Symbol with the given namespace and name.
symbol?
Return true if x is a Symbol
sync
transaction-flags => TBD, pass nil for now Runs the exprs (in an implicit do) in a transaction that encompasses exprs and any nested calls. Starts a transaction if none is already running on this thread. Any uncaught exception will abort the transaction and flow out of sync. The exprs may be run more than once, but any effects on Refs will be atomic."]
        "t" [ "take
Returns a lazy sequence of the first n items in coll, or all items if there are fewer than n.
take-last
Returns a seq of the last n items in coll. Depending on the type of coll may be no better than linear time. For vectors, see also subvec.
take-nth
Returns a lazy seq of every nth item in coll.
take-while
Returns a lazy sequence of successive items from coll while (pred item) returns true. pred must be free of side-effects.
test
test [v] finds fn at key :test in var metadata and calls it, presuming failure will throw exception
the-ns
If passed a namespace, returns it. Else, when passed a symbol, returns the namespace named by it, throwing an exception if not found.
thread-bound?
Returns true if all of the vars provided as arguments have thread-local bindings. Implies that set!'ing the provided vars will succeed. Returns true if no vars are provided.
throw
Evaluates the exprs in order, then, in parallel, rebinds the bindings of the recursion point to the values of the exprs. See http://clojure.org/special_forms for more information.
time
Evaluates expr and prints the time it took. Returns the value of expr.
to-array
Returns an array of Objects containing the contents of coll, which can be any Collection. Maps to java.util.Collection.toArray().
to-array-2d
Returns a (potentially-ragged) 2-dimensional array of Objects containing the contents of coll, which can be any Collection of any Collection.
trampoline
trampoline can be used to convert algorithms requiring mutual recursion without stack consumption. Calls f with supplied args, if any. If f returns a fn, calls that fn with no arguments, and continues to repeat, until the return value is not a fn, then returns that non-fn value. Note that if you want to return a fn as a final value, you must wrap it in some data structure and unpack it after trampoline returns.
transient
Returns a new, transient version of the collection, in constant time.
tree-seq
Returns a lazy sequence of the nodes in a tree, via a depth-first walk. branch? must be a fn of one arg that returns true if passed a node that can have children (but may not). children must be a fn of one arg that returns a sequence of the children. Will only be called on nodes for which branch? returns true. Root is the root node of the tree.
true?
Returns true if x is the value true, false otherwise.
try
The exprs are evaluated and, if no exceptions occur, the value of the last is returned. If an exception occurs and catch clauses are provided, each is examined in turn and the first for which the thrown exception is an instance of the named class is considered a matching catch clause. If there is a matching catch clause, its exprs are evaluated in a context in which name is bound to the thrown exception, and the value of the last is the return value of the function. If there is no matching catch clause, the exception propagates out of the function. Before returning, normally or abnormally, any finally exprs will be evaluated for their side effects. See http://clojure.org/special_forms for more information.
type
Returns the :type metadata of x, or its Class if none"]
        "u" [ "unchecked-add
Returns the sum of x and y, both long. Note - uses a primitive operator subject to overflow.
unchecked-add-int
Returns the sum of x and y, both int. Note - uses a primitive operator subject to overflow.
unchecked-byte
Coerce to byte. Subject to rounding or truncation.
unchecked-char
Coerce to char. Subject to rounding or truncation.
unchecked-dec
Returns a number one less than x, a long. Note - uses a primitive operator subject to overflow.
unchecked-dec-int
Returns a number one less than x, an int. Note - uses a primitive operator subject to overflow.
unchecked-divide-int
Returns the division of x by y, both int. Note - uses a primitive operator subject to truncation.
unchecked-double
Coerce to double. Subject to rounding.
unchecked-float
Coerce to float. Subject to rounding.
unchecked-inc
Returns a number one greater than x, a long. Note - uses a primitive operator subject to overflow.
unchecked-inc-int
Returns a number one greater than x, an int. Note - uses a primitive operator subject to overflow.
unchecked-int
Coerce to int. Subject to rounding or truncation.
unchecked-long
Coerce to long. Subject to rounding or truncation.
unchecked-multiply
Returns the product of x and y, both long. Note - uses a primitive operator subject to overflow.
unchecked-multiply-int
Returns the product of x and y, both int. Note - uses a primitive operator subject to overflow.
unchecked-negate
Returns the negation of x, a long. Note - uses a primitive operator subject to overflow.
unchecked-negate-int
Returns the negation of x, an int. Note - uses a primitive operator subject to overflow.
unchecked-remainder-int
Returns the remainder of division of x by y, both int. Note - uses a primitive operator subject to truncation.
unchecked-short
Coerce to short. Subject to rounding or truncation.
unchecked-subtract
Returns the difference of x and y, both long. Note - uses a primitive operator subject to overflow.
unchecked-subtract-int
Returns the difference of x and y, both int. Note - uses a primitive operator subject to overflow.
underive
Removes a parent/child relationship between parent and tag. h must be a hierarchy obtained from make-hierarchy, if not supplied defaults to, and modifies, the global hierarchy.
unquote
no doc
unquote-splicing
no doc
unsigned-bit-shift-right
Bitwise shift right, without sign-extension.
update-in
'Updates' a value in a nested associative structure, where ks is a sequence of keys and f is a function that will take the old value and any supplied args and return the new value, and returns a new nested structure. If any levels do not exist, hash-maps will be created.
update-proxy
Takes a proxy instance and a map of strings (which must correspond to methods of the proxy superclass/superinterfaces) to fns (which must take arguments matching the corresponding method, plus an additional (explicit) first arg corresponding to this, and updates (via assoc) the proxy's fn map. nil can be passed instead of a fn, in which case the corresponding method will revert to the default behavior. Note that this function can be used to update the behavior of an existing instance without changing its identity. Returns the proxy.
use
Like 'require, but also refers to each lib's namespace using clojure.core/refer. Use :use in the ns macro in preference to calling this directly. 'use accepts additional options in libspecs: :exclude, :only, :rename. The arguments and semantics for :exclude, :only, and :rename are the same as those documented for clojure.core/refer."]
        "v" [ "val
Returns the value in the map entry.
vals
Returns a sequence of the map's values, in the same order as (seq map).
var
The symbol must resolve to a var, and the Var object itself (not its value) is returned. The reader macro #'x expands to (var x). See http://clojure.org/special_forms for more information.
var-get
Gets the value in the var object
var-set
Sets the value in the var object to val. The var must be thread-locally bound.
var?
Returns true if v is of type clojure.lang.Var
vary-meta
Returns an object of the same type and value as obj, with (apply f (meta obj) args) as its metadata.
vec
Creates a new vector containing the contents of coll. Java arrays will be aliased and should not be modified.
vector
Creates a new vector containing the args.
vector-of
Creates a new vector of a single primitive type t, where t is one of :int :long :float :double :byte :short :char or :boolean. The resulting vector complies with the interface of vectors in general, but stores the values unboxed internally. Optionally takes one or more elements to populate the vector.
vector?
Return true if x implements IPersistentVector"]
        "w" [ "when
Evaluates test. If logical true, evaluates body in an implicit do.
when-first
bindings => x xs Roughly the same as (when (seq xs) (let [x (first xs)] body)) but xs is evaluated only once
when-let
bindings => binding-form test When test is true, evaluates body with binding-form bound to the value of test
when-not
Evaluates test. If logical false, evaluates body in an implicit do.
when-some
bindings => binding-form test When test is not nil, evaluates body with binding-form bound to the value of test
while
Repeatedly executes body while test expression is true. Presumes some side-effect will cause test to become false/nil. Returns nil
with-bindings
Takes a map of Var/value pairs. Installs for the given Vars the associated values as thread-local bindings. The executes body. Pops the installed bindings after body was evaluated. Returns the value of body.
with-bindings*
Takes a map of Var/value pairs. Installs for the given Vars the associated values as thread-local bindings. Then calls f with the supplied arguments. Pops the installed bindings after f returned. Returns whatever f returns.
with-in-str
Evaluates body in a context in which *in* is bound to a fresh StringReader initialized with the string s.
with-loading-context
no doc
with-local-vars
varbinding=> symbol init-expr Executes the exprs in a context in which the symbols are bound to vars with per-thread bindings to the init-exprs. The symbols refer to the var objects themselves, and must be accessed with var-get and var-set
with-meta
Returns an object of the same type and value as obj, with map m as its metadata.
with-open
bindings => [name init ...] Evaluates body in a try expression with names bound to the values of the inits, and a finally clause that calls (.close name) on each name in reverse order.
with-out-str
Evaluates exprs in a context in which *out* is bound to a fresh StringWriter. Returns the string created by any nested printing calls.
with-precision
Sets the precision and rounding mode to be used for BigDecimal operations. Usage: (with-precision 10 (/ 1M 3)) or: (with-precision 10 :rounding HALF_DOWN (/ 1M 3)) The rounding mode is one of CEILING, FLOOR, HALF_UP, HALF_DOWN, HALF_EVEN, UP, DOWN and UNNECESSARY; it defaults to HALF_UP.
with-redefs
binding => var-symbol temp-value-expr Temporarily redefines Vars while executing the body. The temp-value-exprs will be evaluated and each resulting value will replace in parallel the root value of its Var. After the body is executed, the root values of all the Vars will be set back to their old values. These temporary changes will be visible in all threads. Useful for mocking out functions during testing.
with-redefs-fn
Temporarily redefines Vars during a call to func. Each val of binding-map will replace the root value of its key which must be a Var. After func is called with no args, the root values of all the Vars will be set back to their old values. These temporary changes will be visible in all threads. Useful for mocking out functions during testing."]
        "x" [ "xml-seq
A tree seq on the xml elements as per xml/parse"]
        "z" [ "zero?
Returns true if num is zero, else false
zipmap
Returns a map with the keys mapped to the corresponding vals."]
        }
   key
))
