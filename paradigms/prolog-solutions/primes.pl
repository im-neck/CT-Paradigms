find_prime_divisors(N, Divisors) :-
integer(N),!,
    find_divisors(N, 2, Divisors).

find_divisors(1, _, []):-! .

find_divisors(N, X, [X | Divisors]) :-
    N mod X =:= 0,
 !,
    N1 is N // X,
    find_divisors(N1, X, Divisors).

find_divisors(N, X, Divisors) :-
    X1 is X + 1,
    find_divisors(N, X1, Divisors).
%-------------
find_prime_divisors(N, Divisors):-  N1 is 1, unknown_num(N1,Divisors, N).

unknown_num(X,[T|H], Res):- unknown_num(X*T,H, Res).
unknown_num(X,[], Res):- Res is X, !.


arrays_equal([], []) :- !.

arrays_equal([H|T1], [H|T2]) :-
    arrays_equal(T1, T2).

% :NOTE: prime_divisors(N, [2,2,2,3]) -> yes: N / 24.
prime_divisors(N, Divisors):-find_prime_divisors(N, Divisors).

count([], 0).
count([_ | T], R) :- count(T, TR), R is TR + 1.
prime(N):- find_prime_divisors(N, L), count(L, 1).
composite(1) :- !, fail.
composite(N):- \+ prime(N).



% prime_index(2, 1)   (число, номер)

prime_index(2, 1) :- !.
prime_index(P, N) :- 
    P > 2,
    find_pr_ind(P, N, 2, 1).

% P- число N - номер


find_pr_ind(P, N, TempP, TempN) :-
    TempP < P,
    TempP1 is TempP + 1,
    prime(TempP),
 !,
    TempN1 is TempN + 1,
    find_pr_ind(P, N, TempP1, TempN1).

find_pr_ind(P, N, TempP, TempN) :-
    TempP < P,
    TempP1 is TempP + 1,
   \+ prime(TempP),
    find_pr_ind(P, N, TempP1, TempN).

find_pr_ind(P, N, P, N) :- prime(P),!.
