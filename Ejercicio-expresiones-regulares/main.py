import re

# Condiciones generales para la búsqueda de expresiones regulares
REGEX = '(T0)(.*?)(T1)(.*?)(T2)(.*?)(T3)(.*?)(T4)(.*?)(T5)(.*?)'
REEMPLAZO = '\g<2>\g<4>\g<6>\g<8>\g<10>\g<12>'

# Abrimos el archivo y leemos su contenido almacenandolo en una variable
f = open("LogLinealHorizontalSimple.txt", "r")
leer = f.read()
f.close()

# Nos fijamos cuantas veces se repite la secuencia que buscamos y la reemplazamos con lo que nos sobra
textoEncontrado = re.subn(REGEX, REEMPLAZO, leer)

# En un nuevo archivo de texto, almacenamos lo que nos sobra del paso anterior
m = textoEncontrado[0]
f = open("LogLinealHorizontalComplejo.txt", "w")
f.write(m)
f.close()

# Abrimos el nuevo archivo y leemos su contenido almacenandolo en una variable
f = open("LogLinealHorizontalComplejo.txt")
leer2 = f.read()
f.close()

# Nos fijamos cuantas veces se repite la secuencia que buscamos y la reemplazamos con lo que nos sobra
textoEncontrado2 = re.subn(REGEX, REEMPLAZO, leer2)

# Realizamos las impresiones de los distintos archivos
print('Comienzo')
print("('", leer, "', 0)", sep='')
print(textoEncontrado)
print(textoEncontrado2)

if textoEncontrado[0] == '':
    if textoEncontrado2[0] == '':
        print("El test finalizó OK")
else:
    print("El test finalizó FAIL, han sobrado transiciones")
