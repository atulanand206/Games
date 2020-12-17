require "string_calculator"

describe StringCalculator do

  describe ".add" do
    context "given an empty string" do
      it "returns zero" do
        expect(StringCalculator.add("")).to eq(0)
      end
    end

    context "given 5" do
      it "returns 5" do
        expect(StringCalculator.add("5")).to eq(5)
      end
    end

    context "given 10" do
      it "returns 10" do
        expect(StringCalculator.add("10")).to eq(10)
      end
    end

    context "two numbers" do
      context "given 2, 5" do
        it "returns 7" do
          expect(StringCalculator.add("2,5")).to eq(7)
        end
      end

      context "given 14, 105" do
        it "returns 119" do
          expect(StringCalculator.add("14,105")).to eq(119)
        end
      end
    end
  end
end