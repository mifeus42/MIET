using System;
using System.IO;
using Xunit;

namespace lab2.Tests
{
    public class UnitTest1
    {
        [Fact]
        public void TestIf1()
        {
            double a, b, c, d, e, f;
            a = 0;
            b = 0;
            e = 0;
            c = 0;
            d = 0;
            f = 0;

            Console.SetIn(new StringReader($"{a}\r\n{b}\r\n{c}\r\n{d}\r\n{e}\r\n{f}\r\n"));

            StringWriter stringWriter = new StringWriter();
            Console.SetOut(stringWriter);

            lab2.Program.Main(new string[] { });

            Assert.Equal("5", stringWriter.ToString().Split(Environment.NewLine)[0]);

        }
        [Fact]
        public void TestIf2Option1()
        {
            double a, b, c, d, e, f;
            a = 1;
            b = 0;
            e = 1;
            c = 1;
            d = 1;
            f = 1;

            Console.SetIn(new StringReader($"{a}\r\n{b}\r\n{c}\r\n{d}\r\n{e}\r\n{f}\r\n"));

            StringWriter stringWriter = new StringWriter();
            Console.SetOut(stringWriter);

            lab2.Program.Main(new string[] { });

            Assert.Equal("2 1 0", stringWriter.ToString().Split(Environment.NewLine)[0]);

        }
        [Fact]
        public void TestIf2Option2()
        {
            double a, b, c, d, e, f;
            a = 1;
            b = 2;
            e = 4;
            c = 1;
            d = 1;
            f = 2;

            Console.SetIn(new StringReader($"{a}\r\n{b}\r\n{c}\r\n{d}\r\n{e}\r\n{f}\r\n"));

            StringWriter stringWriter = new StringWriter();
            Console.SetOut(stringWriter);

            lab2.Program.Main(new string[] { });

            Assert.Equal("2 -0 2", stringWriter.ToString().Split(Environment.NewLine)[0]);

        }
        [Fact]
        public void TestIf3Option1()
        {
            double a, b, c, d, e, f;
            a = 1;
            b = 1;
            e = 2;
            c = 1;
            d = 1;
            f = 3;

            Console.SetIn(new StringReader($"{a}\r\n{b}\r\n{c}\r\n{d}\r\n{e}\r\n{f}\r\n"));

            StringWriter stringWriter = new StringWriter();
            Console.SetOut(stringWriter);

            lab2.Program.Main(new string[] { });

            Assert.Equal("0", stringWriter.ToString().Split(Environment.NewLine)[0]);

        }
        [Fact]
        public void TestIf3Option2Option1()
        {
            double a, b, c, d, e, f;
            a = 0;
            b = 0;
            e = 0;
            c = 0;
            d = 1;
            f = 0;

            Console.SetIn(new StringReader($"{a}\r\n{b}\r\n{c}\r\n{d}\r\n{e}\r\n{f}\r\n"));

            StringWriter stringWriter = new StringWriter();
            Console.SetOut(stringWriter);

            lab2.Program.Main(new string[] { });

            Assert.Equal("4 0", stringWriter.ToString().Split(Environment.NewLine)[0]);

        }
        [Fact]
        public void TestIf3Option2Option2()
        {
            double a, b, c, d, e, f;
            a = 0;
            b = 1;
            e = 0;
            c = 0;
            d = 0;
            f = 0;

            Console.SetIn(new StringReader($"{a}\r\n{b}\r\n{c}\r\n{d}\r\n{e}\r\n{f}\r\n"));

            StringWriter stringWriter = new StringWriter();
            Console.SetOut(stringWriter);

            lab2.Program.Main(new string[] { });

            Assert.Equal("4 0", stringWriter.ToString().Split(Environment.NewLine)[0]);

        }
        [Fact]
        public void TestIf3Option3Option1()
        {
            double a, b, c, d, e, f;
            a = 0;
            b = 0;
            e = 0;
            c = 1;
            d = 0;
            f = 0;

            Console.SetIn(new StringReader($"{a}\r\n{b}\r\n{c}\r\n{d}\r\n{e}\r\n{f}\r\n"));

            StringWriter stringWriter = new StringWriter();
            Console.SetOut(stringWriter);

            lab2.Program.Main(new string[] { });

            Assert.Equal("3 0", stringWriter.ToString().Split(Environment.NewLine)[0]);

        }
        [Fact]
        public void TestIf3Option3Option2()
        {
            double a, b, c, d, e, f;
            a = 1;
            b = 0;
            e = 0;
            c = 0;
            d = 0;
            f = 0;

            Console.SetIn(new StringReader($"{a}\r\n{b}\r\n{c}\r\n{d}\r\n{e}\r\n{f}\r\n"));

            StringWriter stringWriter = new StringWriter();
            Console.SetOut(stringWriter);

            lab2.Program.Main(new string[] { });

            Assert.Equal("3 0", stringWriter.ToString().Split(Environment.NewLine)[0]);

        }
        [Fact]
        public void TestIf3Option4()
        {
            double a, b, c, d, e, f;
            a = 0;
            b = 0;
            e = 2;
            c = 0;
            d = 0;
            f = 1;

            Console.SetIn(new StringReader($"{a}\r\n{b}\r\n{c}\r\n{d}\r\n{e}\r\n{f}\r\n"));

            StringWriter stringWriter = new StringWriter();
            Console.SetOut(stringWriter);

            lab2.Program.Main(new string[] { });

            Assert.Equal("0", stringWriter.ToString().Split(Environment.NewLine)[0]);

        }
        [Fact]
        public void TestIf4Option1()
        {
            double a, b, c, d, e, f;
            a = 0;
            b = 1;
            e = 0;
            c = 0;
            d = 1;
            f = 0;

            Console.SetIn(new StringReader($"{a}\r\n{b}\r\n{c}\r\n{d}\r\n{e}\r\n{f}\r\n"));

            StringWriter stringWriter = new StringWriter();
            Console.SetOut(stringWriter);

            lab2.Program.Main(new string[] { });

            Assert.Equal("4 0", stringWriter.ToString().Split(Environment.NewLine)[0]);

        }
        [Fact]
        public void TestIf4Option3()
        {
            double a, b, c, d, e, f;
            a = 0;
            b = 1;
            e = 1;
            c = 0;
            d = 1;
            f = 1;

            Console.SetIn(new StringReader($"{a}\r\n{b}\r\n{c}\r\n{d}\r\n{e}\r\n{f}\r\n"));

            StringWriter stringWriter = new StringWriter();
            Console.SetOut(stringWriter);

            lab2.Program.Main(new string[] { });

            Assert.Equal("4 1", stringWriter.ToString().Split(Environment.NewLine)[0]);

        }
        [Fact]
        public void TestIf5Option1()
        {
            double a, b, c, d, e, f;
            a = 1;
            b = 0;
            e = 0;
            c = 1;
            d = 0;
            f = 0;

            Console.SetIn(new StringReader($"{a}\r\n{b}\r\n{c}\r\n{d}\r\n{e}\r\n{f}\r\n"));

            StringWriter stringWriter = new StringWriter();
            Console.SetOut(stringWriter);

            lab2.Program.Main(new string[] { });

            Assert.Equal("3 0", stringWriter.ToString().Split(Environment.NewLine)[0]);

        }
        [Fact]
        public void TestIf5Option3()
        {
            double a, b, c, d, e, f;
            a = 1;
            b = 0;
            e = 1;
            c = 1;
            d = 0;
            f = 1;

            Console.SetIn(new StringReader($"{a}\r\n{b}\r\n{c}\r\n{d}\r\n{e}\r\n{f}\r\n"));

            StringWriter stringWriter = new StringWriter();
            Console.SetOut(stringWriter);

            lab2.Program.Main(new string[] { });

            Assert.Equal("3 1", stringWriter.ToString().Split(Environment.NewLine)[0]);

        }
        [Fact]
        public void TestIf6()
        {
            double a, b, c, d, e, f;
            a = 0;
            b = 0;
            e = 0;
            c = 1;
            d = 1;
            f = 1;

            Console.SetIn(new StringReader($"{a}\r\n{b}\r\n{c}\r\n{d}\r\n{e}\r\n{f}\r\n"));

            StringWriter stringWriter = new StringWriter();
            Console.SetOut(stringWriter);

            lab2.Program.Main(new string[] { });

            Assert.Equal("1 -1 1", stringWriter.ToString().Split(Environment.NewLine)[0]);

        }
        [Fact]
        public void TestIf7()
        {
            double a, b, c, d, e, f;
            a = 1;
            b = 1;
            e = 1;
            c = 0;
            d = 0;
            f = 0;

            Console.SetIn(new StringReader($"{a}\r\n{b}\r\n{c}\r\n{d}\r\n{e}\r\n{f}\r\n"));

            StringWriter stringWriter = new StringWriter();
            Console.SetOut(stringWriter);

            lab2.Program.Main(new string[] { });

            Assert.Equal("1 -1 1", stringWriter.ToString().Split(Environment.NewLine)[0]);

        }
        [Fact]
        public void TestIf10()
        {
            double a, b, c, d, e, f;
            a = 2;
            b = 1;
            e = 1;
            c = 4;
            d = 2;
            f = 2;

            Console.SetIn(new StringReader($"{a}\r\n{b}\r\n{c}\r\n{d}\r\n{e}\r\n{f}\r\n"));

            StringWriter stringWriter = new StringWriter();
            Console.SetOut(stringWriter);

            lab2.Program.Main(new string[] { });

            Assert.Equal("1 -2 1", stringWriter.ToString().Split(Environment.NewLine)[0]);

        }
    }

}

