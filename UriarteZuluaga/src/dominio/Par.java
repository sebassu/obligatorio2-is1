package dominio;

import java.util.Objects;

public class Par<D1, D2> {

    private D1 dato1;
    private D2 dato2;

    public Par(D1 d1, D2 d2) {
        this.dato1 = d1;
        this.dato2 = d2;
    }

    public D1 getDato1() {
        return dato1;
    }

    public void setDato1(D1 dato1) {
        this.dato1 = dato1;
    }

    public D2 getDato2() {
        return dato2;
    }

    public void setDato2(D2 dato2) {
        this.dato2 = dato2;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.dato1);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Par<?, ?> other = (Par<?, ?>) obj;
        return Objects.equals(this.dato1, other.dato1);
    }
}
