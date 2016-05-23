## 2.2 Exemple

### Forme de G2 :

* La forme de G2 sera la même que la forme de G0
* La forme suivante sera la même que la forme de G1

### Forme de Gn :

* Si n est pair, alors la forme de Gn est la même que la forme de G0
* Si n est impair, alors la forme de Gn est la même que la forme de G1

## 3.1.1 Cellules

* Les états distincts de la cellule sont vivant et mort
* Le type de variable le plus approprié pour représenter une cellule est un booléen
* Pour représenter la grille, une matrice est le plus approprié

## 3.1.2 Etudes des règles

* L'état d'une cellule dépend de l'état de ses voisines

### Pseudo-code pour compter les cellules

```
k = 0 # On stocke le nombre de cellules vivantes
Pour p = i-1 à i+1
	Pour q = j-1 à j+1
	     Si G(p,q) = 1 et que (p différent de i et q différent de j) # Si G(p,q) est vivante, alors on incrémente k
	         k = k+1
	     Fin si
	Fin pour
Fin pour
```

### Cellule de bord

Pour G(0,0), on ne considère que les cellules dont les coordonnées sont supérieurs à 0.
Pour une cellule de bord, on ne considère que les cellules dont les coordonnées sont supérieurs à 0.

```
k = 0 # On stocke le nombre de cellules vivantes
Pour p = i-1 à i+1
   Pour q = j-1 à j+1
	Si p >= 0 et q >= 0 et p <= n et q <= m # On considère une grille de taille n,m
	     Si G(p,q) = 1 et que (p différent de i et q différent de j) # Si G(p,q) est vivante, alors on incrémente k
	         k = k+1
	     Fin si
	Fin si
   Fin pour
Fin pour
```

### Fonction step :
```
Fonction Int Comptage(Grille G, i,j)
	k = 0 # On stocke le nombre de cellules vivantes
	Pour p = i-1 à i+1
   		Pour q = j-1 à j+1
			Si p >= 0 et q >= 0 et p <= n - 1 et q <= m - 1 # On considère une grille de taille n,m
	     			Si G(p,q) = 1 et que (p différent de i et q différent de j) # Si G(p,q) est vivante, alors on incrémente k
	         			k = k+1
	     			Fin si
			Fin si
   		Fin pour
	Fin pour

	Retourne k
Fin Fonction

Fonction Grille step(Grille G)
	n = Grille.hauteur
	m = Grille.largeur

	Grille Gnext = new Grille(n,m)

	Pour i de 0 à n - 1
		Pour j de 0 à m - 1
			Int compte = Comptage(G, i, j)

			Si compte = 3
				Gnext(i, j) = 1
			Si G(i,j) = 1 et compte = 2
				Gnext(i, j) = 1
			Sinon
				Gnext(i , j) = 0
			Fin Si
		Fin Pour
	Fin Pour

	Retourne Gnext
Fin Fonction
```

### Complexité du code
Il y a n \* m \* 9 itérations
