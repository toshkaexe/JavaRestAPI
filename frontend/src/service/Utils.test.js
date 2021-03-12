import Utils from "./Utils";

describe("Utils Suite", () => {

  it("UserValue Empty", () => {
    expect(false).toEqual(Utils.isValueNotEmpty(""));
  });


  it("UserValue is not Empty", () => {
    expect(true).toEqual(Utils.isValueNotEmpty("Max Mustermann"));
  });



  it("Email is ok", () => {
    expect(true).toEqual(Utils.isNotEmptyEmail("Max.Mustermann@gmail.com"));
  });


  it("Email is not ok case 1", () => {
    expect(false).toEqual(Utils.isNotEmptyEmail(""));
  });

  it("Email is not ok case 2", () => {
    expect(false).toEqual(Utils.isNotEmptyEmail("Max"));
  });

  it("Email is not ok case 3", () => {
    expect(false).toEqual(Utils.isNotEmptyEmail("Max@"));
  });
  it("Email is not ok case 4", () => {
    expect(false).toEqual(Utils.isNotEmptyEmail("Max@m@.de"));
  });

});
