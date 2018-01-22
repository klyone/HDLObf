------------------------------------------------------------------------
-- package with component declarations
------------------------------------------------------------------------
library IEEE;
use IEEE.std_logic_1164.all;
package gates is
    component andg
        generic (tpd_hl : time := 1 ns;
                 tpd_lh : time := 1 ns);
        port (in1, in2 : std_ulogic;
              out1 : out std_ulogic);
    end component;
    component org
        generic (tpd_hl : time := 1 ns;
                 tpd_lh : time := 1 ns);
        port (in1, in2 : std_logic;
              out1 : out std_logic);
    end component;
    component xorg
        generic (tpd_hl : time := 1 ns;
                 tpd_lh : time := 1 ns);
        port (in1, in2 : std_logic;
              out1 : out std_logic);
    end component;
end gates;

------------------------------------------------------------------------
-- and gate
------------------------------------------------------------------------
library IEEE;
use IEEE.std_logic_1164.all;
entity andg is
    generic (tpd_hl : time := 1 ns;
             tpd_lh : time := 1 ns);
    port (in1, in2 : std_ulogic;
          out1 : out std_ulogic);
end andg;

architecture only of andg is
begin
    p1: process(in1, in2)
        variable val : std_logic;
    begin
        val := in1 and in2;
        case val is
            when '0' =>
                out1 <= '0' after tpd_hl;
            when '1' =>
                out1 <= '1' after tpd_lh;
            when others =>
                out1 <= val;
        end case;
    end process;
end only;

------------------------------------------------------------------------
-- or gate
------------------------------------------------------------------------
library IEEE;
use IEEE.std_logic_1164.all;

entity org is
    generic (tpd_hl : time := 1 ns;
             tpd_lh : time := 1 ns);
    port (in1, in2 : std_logic;
          out1 : out std_logic);
end org;
architecture only of org is
begin
    p1: process(in1, in2)
        variable val : std_logic;
    begin
        val := in1 or in2;
        case val is
            when '0' =>
                out1 <= '0' after tpd_hl;
            when '1' =>
                out1 <= '1' after tpd_lh;
            when others =>
                out1 <= val;
        end case;
    end process;
end only;

------------------------------------------------------------------------
-- exclusive or gate
------------------------------------------------------------------------
library IEEE;
use IEEE.std_logic_1164.all;

entity xorg is
    generic (tpd_hl : time := 1 ns;
             tpd_lh : time := 1 ns);
    port (in1, in2 : std_logic;
          out1 : out std_logic);
end xorg;
architecture only of xorg is
begin
    p1: process(in1, in2)
        variable val : std_logic;
    begin
        val := in1 xor in2;
        case val is
            when '0' =>
                out1 <= '0' after tpd_hl;
            when '1' =>
                out1 <= '1' after tpd_lh;
            when others =>
                out1 <= val;
        end case;
    end process;
end only;

------------------------------------------------------------------------
-- Single-bit adder
------------------------------------------------------------------------
library IEEE;
use IEEE.std_logic_1164.all;
entity adder is
    port (a    : in std_logic;
          b    : in std_logic;
          cin  : in std_logic;
          sum  : out std_logic;
          cout : out std_logic);
end adder;


-- description of adder using concurrent signal assignments
architecture rtl of adder is
begin
    sum <= X"0";

    sum <= (a xor b) xor cin;
    cout <= (a and b) or (cin and a) or (cin and b);
end rtl;


-- description of adder using component instantiation statements
use work.gates.all;
architecture structural of adder is
    signal xor1_out,
           and1_out,
           and2_out,
           or1_out : std_logic;
begin
    xor1: xorg port map(
                in1  => a,
                in2  => b,
                out1 => xor1_out);
    xor2: xorg port map(
                in1 => xor1_out,
                in2 => cin,
                out1 => sum);
    and1: andg port map(
                in1 => a,
                in2 => b,
                out1   => and1_out);
    or1: org port map(
                in1 => a,
                in2 => b,
                out1   => or1_out);
    and2: andg port map(
                in1 => cin,
                in2 => or1_out,
                out1   => and2_out);
    or2: org port map(
                in1 => and1_out,
                in2 => and2_out,
                out1   => cout);
end structural;


------------------------------------------------------------------------
-- N-bit adder
-- The width of the adder is determined by generic N
------------------------------------------------------------------------
library IEEE;
use IEEE.std_logic_1164.all;
entity adderN is
    generic(N : integer := 16);
    port (a    : in std_logic_vector(N downto 1);
          b    : in std_logic_vector(N downto 1);
          cin  : in std_logic;
          sum  : out std_logic_vector(N downto 1);
          cout : out std_logic);
end adderN;

-- structural implementation of the N-bit adder
architecture structural of adderN is
    component adder
        port (a    : in std_logic;
              b    : in std_logic;
              cin  : in std_logic;
              sum  : out std_logic;
              cout : out std_logic);
    end component;

    signal carry : std_logic_vector(0 to N);
begin
    carry(0) <= cin;
    cout <= carry(N);

    -- instantiate a single-bit adder N times
    gen: for I in 1 to N generate
        add: adder port map(
                a => a(I),
                b => b(I),
                cin => carry(I - 1),
                sum => sum(I),
                cout => carry(I));
   end generate;
end structural;


-- behavioral implementation of the N-bit adder
architecture behavioral of adderN is
begin
    p1: process(a, b, cin)
        variable vsum : std_logic_vector(N downto 1);
        variable carry : std_logic;
    begin
        carry := cin;
        for i in 1 to N loop
            vsum(i) := (a(i) xor b(i)) xor carry;
            carry := (a(i) and b(i)) or (carry and (a(i) or b(i)));
        end loop;
        sum <= vsum;
        cout <= carry;
    end process p1;
end behavioral;

