
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import org.junit.jupiter.api.Test;
class RekeningnummerTest {
    @Test void BE72091012240116IsCorrect() {
        // De constructor oproepen met een correct rekeningnummer mag geen exception werpen.
        // Als dit wel gebeurt, is dit voor JUnit een test die faalt met
        // Je moet daarvoor geen assertThat typen.
        new Rekeningnummer("BE72091012240116");
    }
    @Test void BE68539007547034IsCorrect() {
        new Rekeningnummer("BE68539007547034");
    }
    @Test void BE02063588295840IsCorrect() {
        new Rekeningnummer("BE02063588295840"); // met eencontrolegetal < 10
    }
    @Test void BE720910122401160IsTeLang() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Rekeningnummer("BE720910122401160"));
    }
    @Test void BE7209101224011IsTeKort() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Rekeningnummer("BE7209101224011"));
    }
    @Test void NL72091012240116IsVerkeerdWegensNietBelgisch() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Rekeningnummer("NL72091012240116"));
    }
    @Test void BEX209101224011YBevatVerkeerdeTekens() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Rekeningnummer("BEX209101224011Y"));
    }
    @Test void BE01091012240116BevatEenTeKleinControleGetal() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Rekeningnummer("BE01091012240116"));
    }
    @Test void BE99091012240116BevatEenTeGrootControleGetal() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Rekeningnummer("BE99091012240116"));
    }
    @Test void BE72091012240115BevatEenVerkeerdeControleBerekening() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Rekeningnummer("BE72091012240115"));
    }
    @Test void nummerMetNullIsVerkeerd() {
        assertThatNullPointerException().isThrownBy(() -> new Rekeningnummer(null));
    }
    @Test void leegNummerIsVerkeerd() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Rekeningnummer(""));
    }
    @Test void toStringGeeftHetNummerTerug() {
        var nummer = "BE72091012240116";
        assertThat(new Rekeningnummer(nummer)).hasToString(nummer);
    }
}