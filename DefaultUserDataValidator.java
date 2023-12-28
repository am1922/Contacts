public class DefaultUserDataValidator implements UserDataValidator {
    @Override
    public void validate(User user) throws UserDataFormatException {
        if (user.getLastName().isEmpty() || user.getFirstName().isEmpty() ||
                user.getMiddleName().isEmpty() || user.getBirthDate().isEmpty() ||
                user.getPhoneNumber().isEmpty() || user.getGender().isEmpty()) {
            throw new UserDataFormatException("Отсутствуют обязательные данные.");
        }

        validateDataFormats(user);
    }

    private void validateDataFormats(User user) throws UserDataFormatException {
        if (!user.getBirthDate().matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            throw new UserDataFormatException("Неверный формат даты рождения. Ожидался формат dd.mm.yyyy.");
        }

        try {
            Long.parseLong(user.getPhoneNumber());
        } catch (NumberFormatException e) {
            throw new UserDataFormatException("Неверный формат номера телефона. Ожидалось целое беззнаковое число.");
        }

        if (!user.getGender().matches("[fmFM]")) {
            throw new UserDataFormatException("Неверный формат пола. Ожидался символ 'f' или 'm'.");
        }
    }
}
