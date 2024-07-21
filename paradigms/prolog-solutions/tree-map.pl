map_build([], nil).
map_build([(Key, Value) | Tail], R) :-
    map_build(Tail, T),
    map_put(T, Key, Value, R).

map_put(nil, Key, Value, node(Key, Value, nil, nil)).
map_put(node(K, V, L, R), Key, Value, node(K, V, NL, R)) :-
    Key < K,
    map_put(L, Key, Value, NL).
map_put(node(K, V, L, R), Key, Value, node(K, V, L, NR)) :-
    Key > K,
    map_put(R, Key, Value, NR).
map_put(node(K, V, L, R), Key, Value, node(K, Value, L, R)) :-
    Key is K.

map_get(node(Key, Value, _, _), Key, Value).

map_get(node(K, _, L, _), Key, Value) :-
    Key < K,
    map_get(L, Key, Value).
map_get(node(K, _, _, R), Key, Value) :-
    Key > K,
    map_get(R, Key, Value).

map_replace(nil, _, _, nil).
map_replace(node(Key, _, L, R), Key, Value, node(Key, Value, L, R)).

map_replace(node(K, V, L, R), Key, Value, node(K, V, NL, R)) :-
    Key < K,
    map_replace(L, Key, Value, NL).
map_replace(node(K, V, L, R), Key, Value, node(K, V, L, NR)) :-
    Key > K,
    map_replace(R, Key, Value, NR).
